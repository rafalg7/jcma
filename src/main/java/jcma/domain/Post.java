package jcma.domain;

public class Post {
// ------------------------------ FIELDS ------------------------------

    private User author;

    private String content;

    private String title;

// --------------------------- CONSTRUCTORS ---------------------------

    public Post()
    {
    }

    public Post(User author, String content, String title)
    {
        this.author = author;
        this.content = content;
        this.title = title;
    }

// --------------------- GETTER / SETTER METHODS ---------------------

    public User getAuthor()
    {
        return author;
    }

    public void setAuthor(User author)
    {
        this.author = author;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }
}
