package life.mashangkaishi.manongcommunity.util;

import com.beust.jcommander.internal.Lists;
import life.mashangkaishi.manongcommunity.dto.Job;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Spider {

    static {
     System.setProperty("webdriver.chrome.driver", "/downloads/chromedriver");

//       System.setProperty("webdriver.chrome.driver", "D:\\IntelliJProject\\SPIDER\\chromedriver_win32-80.0.3987.106\\chromedriver.exe");
    }

    public ArrayList<Job> getJobs() {
        ArrayList<Job> list=new ArrayList<>();
        try {

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless","--whitelisted-ips","--no-sandbox","--disable-extensions");
//            options.AddArgument("--headless");
//            options.AddArgument("--whitelisted-ips");
//            options.AddArgument("--no-sandbox");
//            options.AddArgument("--disable-extensions");
            WebDriver driver = new ChromeDriver(options);

            // 进入首页
            driver.get("https://www.lagou.com/jobs/list_Java?isSchoolJob=1");
            ArrayList<Job> jobs = new ArrayList<>();
            //设置筛选条件
            choseOptions(driver);
            //开始解析页面，分页获取工资
            findMoneyByPagination(driver, jobs,1);
            list = jobs;

            driver.quit();
        } catch (Exception e) {
        }
        return list;
    }



    private static void findMoneyByPagination(WebDriver driver, ArrayList<Job> jobs,int page) {

        List<WebElement> jobElements = driver.findElements(By.className("list_item_top"));

        for (WebElement jobElement : jobElements) {
            Job job = new Job();
            String money = jobElement.findElement(By.className("money")).getText();
            String time = jobElement.findElement(By.className("format-time")).getText();
            String companyName = jobElement.findElement(By.className("company_name")).getText();
            String attribute = jobElement.findElement(By.className("position_link")).getAttribute("href");
            String industry = jobElement.findElement(By.className("industry")).getText();
            String jobname = jobElement.findElement(By.className("position_link")).findElement(By.tagName("h3")).getText();
            job.setCompany(companyName);
            job.setJobname(jobname);
            job.setScale(industry);
            job.setTime(time);
            job.setMoney(money);
            job.setUrl(attribute);
            jobs.add(job);
        }
        WebElement nextPageElement = driver.findElement(By.className("pager_next"));
        boolean canClickNextPageBtn = !nextPageElement.getAttribute("class").contains("pager_next_disabled");
        if (canClickNextPageBtn&&page>0) {
            nextPageElement.click();
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
            }
            findMoneyByPagination(driver, jobs,page-1);
        }
    }

    private static void choseOptions(WebDriver driver) {
        // 选择城市
        String cityName = "重庆";

        WebElement geiyebuyao = driver.findElement(By.xpath("//div[@class='body-container showData']//div[@class='body-box']//div[contains(text(),'给也不要')]"));
        geiyebuyao.click();

//        WebElement cityAuthorElement = driver.findElement(By.xpath("//div[@class='other-hot-city']//a[contains(text(),'" + cityName + "')]"));
//        cityAuthorElement.click();

        // 选择工作经验
        // 不限 应届毕业生 3年及以下 3-5年 5-10年 10年以上 不要求
        choseByTitle(driver, "应届", "工作性质");

        // 选择学历要求
        // 不限 大专 本科 硕士 博士 不要求
        choseByTitle(driver, "本科", "学历要求");

        // 选择公司规模
//        List<String> companyMembers = new ArrayList<String>();
//        companyMembers.add("不限");
//
//        for (String companyMember : companyMembers) {
//            choseByTitle(driver, companyMember, "公司规模");
//        }
        // 选择行业领域
        choseByTitle(driver, "移动互联网", "行业领域");
    }

    private static void choseByTitle(WebDriver driver, String companyMember, String companyMemberChosenTitle) {
        WebElement companyElement = driver.findElement(By.xpath("//li[@class='multi-chosen']/span[contains(text(),'" + companyMemberChosenTitle + "')]"));
        WebElement companyAuthorElement = companyElement.findElement(By.xpath("../a[contains(text(),'" + companyMember + "')]"));
        companyAuthorElement.click();
    }


}
