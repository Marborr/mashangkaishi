package life.mashangkaishi.manongcommunity.util;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
@Component
public class TimeFlush {
    public boolean timeout(String tim) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long nowTime = new Date().getTime();
        String[] ts = tim.split("T");
        String split = ts[1].substring(0, 9);
        String s = ts[0] + " " + split;
        long time = sdf.parse(s).getTime();
        return time - nowTime>0?false:true;
    }

}
