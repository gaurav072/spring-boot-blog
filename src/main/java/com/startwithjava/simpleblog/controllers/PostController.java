package com.startwithjava.simpleblog.controllers;
import com.startwithjava.simpleblog.entities.Post;
import com.startwithjava.simpleblog.services.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    PostService postService;
    @RequestMapping("list")
    public ModelAndView index()
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("admin/pages/list");
        return mav;
    }
    @GetMapping("new")
    public ModelAndView add()
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("admin/pages/add");
        return mav;
    }
    @PostMapping("/post/save")
    public ResponseEntity persistPost(
            @RequestBody Post post) {
        postService.saveOrUpdate(post);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @PostMapping("/api/{id}")
    public ResponseEntity findPost(@PathVariable("id") long id) {
        Post post = postService.findById(id);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("MyResponseHeader", "MyValue");
        return new ResponseEntity<Post>(post,responseHeaders,HttpStatus.OK);
    }
}
