package com.chengqhuster;

import com.chengqhuster.web.HelloController;
import com.chengqhuster.web.UserController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MockServletContext.class})
public class Chapter315ApplicationTests {

    private MockMvc mvc;

    @Before
    public void setUp() {
        mvc = MockMvcBuilders.standaloneSetup(
                new HelloController(),
                new UserController()).build();
    }

    @Test
    public void getHello() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(equalTo("Hello World")));
    }

    @Test
    public void testUserController() throws Exception{
        RequestBuilder request = null;

        //1、get查一下user列表，应该为空
        request = MockMvcRequestBuilders.get("/users/");
        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(equalTo("[]")));

        //2、post一个user
        request = MockMvcRequestBuilders.post("/users/")
                .param("id", "1")
                .param("name", "测试人员")
                .param("age", "20");
        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(equalTo("success")));

        // 3、get获取user列表，应该有刚才插入的数据
        request = MockMvcRequestBuilders.get("/users/");
        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(equalTo("[{\"id\":1,\"name\":\"测试人员\",\"age\":20}]")));

        // 4、put修改id为1的user
        request = MockMvcRequestBuilders.put("/users/1")
                .param("name", "高级测试人员")
                .param("age", "30");
        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.content().string(equalTo("success")));


        // 5、get一个id为1的user
        request = MockMvcRequestBuilders.get("/users/1");
        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.content().string(equalTo("{\"id\":1,\"name\":\"高级测试人员\",\"age\":30}")));

        // 6、del删除id为1的user
        request = MockMvcRequestBuilders.delete("/users/1");
        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.content().string(equalTo("success")));

        //7、get查一下user列表，应该为空
        request = MockMvcRequestBuilders.get("/users/");
        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(equalTo("[]")));
    }
}
