package entities;

import java.util.ArrayList;
import java.util.List;

public class Post {
    private String title;
    private String content;
    private int likes;
    private List<Comment> comments = new ArrayList<>();

    public Post(String title, String content, int likes) {
        this.title = title;
        this.content = content;
        this.likes = likes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void removeComment(Comment comment) {
        comments.remove(comment);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("-------------------------\n");
        sb.append("Title: ").append(title).append("\n");
        sb.append("Content: ").append(content).append("\n");
        sb.append("Likes: ").append(likes).append("\n");
        sb.append("Comments:\n");

        for (Comment c : comments) {
            sb.append("-").append(c.getText()).append("\n");
        }

        sb.append("-------------------------");

        return sb.toString();
    }
}
