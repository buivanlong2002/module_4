package com.codegym.imageofday.controller;

import com.codegym.imageofday.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import javax.transaction.Transactional;
import java.util.List;

@Controller
public class CommentController {

    @Autowired
    private SessionFactory sessionFactory;

    @PostMapping("/submitFeedback")
    @ResponseBody
    @Transactional
    public Comment submitFeedback(@RequestBody Comment comment) {
        Session session = sessionFactory.getCurrentSession();
        session.save(comment);
        return comment;
    }

    @GetMapping("/getComments")
    @ResponseBody
    @Transactional
    public List<Comment> getComments(@RequestParam String date) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Comment WHERE date = :date", Comment.class)
                .setParameter("date", date)
                .getResultList();
    }

    @PostMapping("/likeComment")
    @ResponseBody
    @Transactional
    public Comment likeComment(@RequestParam Long id) {
        Session session = sessionFactory.getCurrentSession();
        Comment comment = session.get(Comment.class, id);
        if (comment != null) {
            comment.setLikes(comment.getLikes() + 1);
            session.update(comment);
        }
        return comment;
    }
}
