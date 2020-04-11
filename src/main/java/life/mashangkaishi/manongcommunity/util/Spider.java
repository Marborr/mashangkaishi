package life.mashangkaishi.manongcommunity.util;

import com.beust.jcommander.internal.Lists;
import life.mashangkaishi.manongcommunity.dto.Job;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Spider {

    static {
      System.setProperty("webdriver.chrome.driver", "/downloads/chromedriver");
       //System.setProperty("webdriver.chrome.driver", "D:\\IntelliJProject\\SPIDER\\chromedriver_win32-80.0.3987.106\\chromedriver.exe");
    }

    public Job getJobs() {
        ArrayList<Job> list=new ArrayList<>();
        try {
            WebDriver driver = new ChromeDriver();
            // 进入首页
            driver.get("https://www.lagou.com/zhaopin/Java/?labelWords=label");
            Map<String, Job> jobs = new HashMap();
            //设置筛选条件
            choseOptions(driver);
            //开始解析页面，分页获取工资
            findMoneyByPagination(driver, jobs);
            list = (ArrayList<Job>) Lists.newArrayList(jobs.values());
            //打印工资
            printMoney(jobs);
            driver.quit();
        } catch (Exception e) {
        }
        return list.get(0);
    }

    private static void printMoney(Map<String, Job> jobs) {
        ArrayList<Job> list = (ArrayList<Job>) Lists.newArrayList(jobs.values());
        Collections.sort(list, new Comparator<Job>() {
            public int compare(Job o1, Job o2) {
                return o2.getCount() - o1.getCount();
            }
        });
        for (Job job : list) {
            System.out.println(job);
        }
    }

    private static void findMoneyByPagination(WebDriver driver, Map<String, Job> map) {
        List<WebElement> jobElements = driver.findElements(By.className("list_item_top"));
        for (WebElement jobElement : jobElements) {
            String money = jobElement.findElement(By.className("money")).getText();
            String companyName = jobElement.findElement(By.className("company_name")).getText();
            if (map.containsKey(money)) {
                Job job = map.get(money);
                job.getCompanies().add(companyName);
                job.setMoney(money);
                job.setCount(job.getCount() + 1);
                map.put(money, job);
            } else {
                Job job = new Job();
                job.getCompanies().add(companyName);
                job.setMoney(money);
                job.setCount(1);
                map.put(money, job);
            }
        }
        WebElement nextPageElement = driver.findElement(By.className("pager_next"));
        boolean canClickNextPageBtn = !nextPageElement.getAttribute("class").contains("pager_next_disabled");
        if (canClickNextPageBtn) {
            nextPageElement.click();
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
            }
            findMoneyByPagination(driver, map);
        }
    }

    private static void choseOptions(WebDriver driver) {
        // 选择城市
        String cityName = "北京";

        WebElement geiyebuyao = driver.findElement(By.xpath("//div[@class='body-container showData']//div[@class='body-box']//div[contains(text(),'给也不要')]"));
        geiyebuyao.click();

        WebElement cityAuthorElement = driver.findElement(By.xpath("//div[@class='other-hot-city']//a[contains(text(),'" + cityName + "')]"));
        cityAuthorElement.click();

        // 选择工作经验
        // 不限 应届毕业生 3年及以下 3-5年 5-10年 10年以上 不要求
        choseByTitle(driver, "3-5年", "工作经验");

        // 选择学历要求
        // 不限 大专 本科 硕士 博士 不要求
        choseByTitle(driver, "本科", "学历要求");

        // 选择公司规模
        List<String> companyMembers = new ArrayList<String>();
        companyMembers.add("50-150人");
        companyMembers.add("150-500人");
        for (String companyMember : companyMembers) {
            choseByTitle(driver, companyMember, "公司规模");
        }
        // 选择行业领域
        choseByTitle(driver, "移动互联网", "行业领域");
    }

    private static void choseByTitle(WebDriver driver, String companyMember, String companyMemberChosenTitle) {
        WebElement companyElement = driver.findElement(By.xpath("//li[@class='multi-chosen']/span[contains(text(),'" + companyMemberChosenTitle + "')]"));
        WebElement companyAuthorElement = companyElement.findElement(By.xpath("../a[contains(text(),'" + companyMember + "')]"));
        companyAuthorElement.click();
    }


}
