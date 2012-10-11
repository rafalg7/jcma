package jcma.domain;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

@Indexed
@XmlRootElement
@Entity
public class Post {
// ------------------------------ FIELDS ------------------------------

    @ManyToOne
    private User author;

    @Field
    private String content;

    @Id
    @GeneratedValue
    private Long id;

    @Field
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

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
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
