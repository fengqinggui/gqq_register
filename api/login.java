package cn.tedu.api;

import com.alibaba.fastjson.JSON;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.io.*;

/**
 * Created by soft01 on 2017/5/4.
 */
@Path("login")
public class login {


    @POST
    @Consumes("application/x-www-form-urlencoded")
    public String adduser(@FormParam("name") String name,@FormParam("pwd") String pwd){
        String jsonstr = add(name,pwd);
        return jsonstr;
    }
    public String add(String name,String pwd){
        PrintWriter pw=null;
        String jsonstr = null;
        try {
            File file = new File("D:/user.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            pw=new PrintWriter(
                    new OutputStreamWriter(
                            new FileOutputStream(
                                    file,true
            ),"UTF-8"
            ),true
            );
            User user = new User(name,pwd);
            jsonstr = JSON.toJSONString(user);
            pw.print(jsonstr);


        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            pw.close();
            return jsonstr;
        }

    }
}
