package cn.tedu.api;

import com.alibaba.fastjson.JSON;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.io.*;

/**
 * Created by soft01 on 2017/5/4.
 */
@Path("deposit")
public class deposit {
    @GET
    @Produces("application/json")
    public String getdeposit(@FormParam("name") String name) throws IOException {
        String depositstr= deposit(name);
        return depositstr;
    }
    public String deposit(String name) throws IOException {
        BufferedReader br = null;
        String jsondeposit = null;
        try {
            File file = new File("D:/user.txt");
            br=new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(file
            ),"UTF-8"
            )
            );
            String b ;
            while ((b=br.readLine())!=null){
                User user = JSON.parseObject(b,User.class);
                if(user.equals(user.getUsername())){
                    jsondeposit = JSON.toJSONString(user);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            br.close();
            return jsondeposit;
        }


    }

}
