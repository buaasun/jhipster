package cn.edu.buaa.jhipster.web.weixin;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

import org.apache.tomcat.util.digester.Digester;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Sun Chenggen on 2015/7/2 0002.
 */
@RestController
@RequestMapping("/weixin")

public class WeixinValidateController {

    @RequestMapping("/validate")
    @ResponseBody

    public String validate(@RequestParam String signature, @RequestParam String timestamp,
                           @RequestParam String nonce, @RequestParam String echostr) {
        if (isValidate(signature, timestamp, nonce)) {
            return echostr;
        }
        return  null;

    }

    private boolean isValidate(@RequestParam String signature, @RequestParam String timestamp,
                               @RequestParam String nonce) {
        final String token = "abcqwe";
        List<String> list = Arrays.asList(token, timestamp, nonce);
        Collections.sort(list);
        String tmpStr = String.join("", list);
        tmpStr = Hashing.sha1().hashString(tmpStr, Charsets.UTF_8).toString();
        if (tmpStr.equals(signature)) {
            return true;
        }
        return
            false;
    }
}
