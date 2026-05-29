package application;

import entities.Comment;
import entities.Post;

public class Main {
    public static void main(String[] args) {

        Comment comment = new Comment("Massa demais!!");
        Comment comment2 = new Comment("Parábens pela conquista");


        Post post = new Post("Novo projeto!!", "Projeto que desenvolvi no java", 30);

        post.addComment(comment);
        post.addComment(comment2);

        System.out.println(post);

        post.removeComment(comment);

        System.out.println(post);
    }
}
