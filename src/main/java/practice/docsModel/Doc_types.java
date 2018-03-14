package practice.docsModel;


import javax.persistence.*;
import java.util.Set;

/**
 * Created by sergi on 04.03.2018.
 */
@Entity(name = "Doc_types")
public class Doc_types {
    @Id
    @Column(name = "id")
    private Long id;

    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "docType", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Document> documents;

    public Set<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(Set<Document> documents) {

        this.documents = documents;
        for (Document document: documents) {
            document.setDocType(this);
        }
    }

    public void addDocument(Document document)
    {
        getDocuments().add(document);
        document.setDocType(this);
    }

    public void removeDocument(Document document)
    {
        getDocuments().remove(document);
        document.setDocType(null);
    }

    @Column(name = "code",
            nullable = false)
    private String code;

    @Column(name = "name",
            nullable = false)
    private String name;

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Doc_types()
    {

    }

}
