package cn.edu.buaa.jhipster.web;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.annotation.ModelAndViewResolver;
import org.springframework.web.servlet.view.InternalResourceView;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

/**
 * Created by Sun Chenggen on 2015/6/29 0029.
 */
@Controller
public class TestController {

    static class OauthRes {

        private String access_token, refresh_token, openid, scope, unionid;
        private long expires_in;

        public String getAccess_token() {
            return access_token;
        }

        public void setAccess_token(String access_token) {
            this.access_token = access_token;
        }

        public String getRefresh_token() {
            return refresh_token;
        }

        public void setRefresh_token(String refresh_token) {
            this.refresh_token = refresh_token;
        }

        public String getOpenid() {
            return openid;
        }

        public void setOpenid(String openid) {
            this.openid = openid;
        }

        public String getScope() {
            return scope;
        }

        public void setScope(String scope) {
            this.scope = scope;
        }

        public String getUnionid() {
            return unionid;
        }

        public void setUnionid(String unionid) {
            this.unionid = unionid;
        }

        public long getExpires_in() {
            return expires_in;
        }

        public void setExpires_in(long expires_in) {
            this.expires_in = expires_in;
        }

        @Override
        public String toString() {
            return "OauthRes{" +
                   "access_token='" + access_token + '\'' +
                   ", refresh_token='" + refresh_token + '\'' +
                   ", openid='" + openid + '\'' +
                   ", scope='" + scope + '\'' +
                   ", unionid='" + unionid + '\'' +
                   ", expires_in=" + expires_in +
                   '}';
        }
    }

    private final Logger log = LoggerFactory.getLogger(TestController.class);

    private final String appID = "wx4a81bdbc2b00e939";
    private final String appsecret = "18d620ba4644b78c424e3431774922fd";
    @Inject
    private RestTemplate restTemplate;

    @RequestMapping({"/", "/metrics"})
    public View index(@RequestParam(required = false) String code,
                      @RequestParam(required = false) String state) {
        log.info("login code={}, state={}", code, state);
        log.info("change1222333331");
        if (StringUtils.isNotEmpty(code)) {
            HashMap resp = restTemplate.getForObject(
                "https://api.weixin.qq.com/sns/oauth2/access_token?appid={appID}&secret={appsecret}&code={code}&grant_type=authorization_code",
                HashMap.class, appID, appsecret, code);
            log.info("resp{}", resp.toString());

        }
        return new InternalResourceView("/index.html");
    }
}
