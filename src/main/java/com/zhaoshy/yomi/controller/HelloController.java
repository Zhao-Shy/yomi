package com.zhaoshy.yomi.controller;

import com.zhaoshy.yomi.entity.Author;
import com.zhaoshy.yomi.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/****************************************
 * @author : zhaoshy
 * @description : 
 * @create_time : 2019/12/8 15:43
 ****************************************
 */

@RestController
public class HelloController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @Autowired
    private Book book;
    
    @GetMapping("/getGlobalData")
    public void getGlobalData(Model model) {
        Map<String, Object> stringObjectMap = model.asMap();
        Set<String> keySet = stringObjectMap.keySet();
        Iterator<String> iterator = keySet.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            Object value = stringObjectMap.get(key);
            System.out.println(key + ">>>>>" + value);
        }
    }

    @GetMapping("/reqParamPre-proces")
    public String book(@ModelAttribute("book") Book book, @ModelAttribute("author") Author author) {
        return book.toString() + ">>>>>" + author.toString();
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping("/upload")
    public String upload(MultipartFile uploadFile, HttpServletRequest request) {
        //表示规划上传文件的保存路径为项目运行目录下的upladFile文件夹
        String realPath = "F:/UpLoadPic/";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(new Date());
        //根据日期对上传文件归类保存
        File file = new File(realPath + format + "/");
        if (!file.isDirectory()) {
            file.mkdirs();
        }
        //给上传文件重命名, 以防重名
        String oldName = uploadFile.getOriginalFilename();
        String newName = UUID.randomUUID().toString()
                + oldName.substring(oldName.lastIndexOf("."), oldName.length()).toString();

        try {
            //文件保存
            uploadFile.transferTo(file);
            //生成上传文件访问路径, 并返回
            String filePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                    + "/uploadFile/" + format + "/" + newName;

            return filePath;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败";
    }

    @GetMapping("/books")
    public ModelAndView books() {
        List<Book> books = new ArrayList<>();

        Book book = new Book();
        book.setId(1);
        book.setAuthor("罗贯中");
        book.setName("三国演义");

        Book book2 = new Book();
        book2.setId(2);
        book2.setAuthor("曹雪芹");
        book2.setName("红楼梦");

        books.add(book);
        books.add(book2);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("books", books);
        modelAndView.setViewName("books");

        return modelAndView;
    }
}