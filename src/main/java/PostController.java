package com.example.bbs;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class PostController {

    private final PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "index";
    }

    @PostMapping("/create")
    public String create(@RequestParam String title,
                         @RequestParam String content) {

        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        postRepository.save(post);

        return "redirect:/";
    }
}