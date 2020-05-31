
package pl.egu.agh.soa.lab;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the pl.egu.agh.soa.lab package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddNewStudent_QNAME = new QName("http://lab.soa.agh.edu.pl/", "addNewStudent");
    private final static QName _AddNewStudentResponse_QNAME = new QName("http://lab.soa.agh.edu.pl/", "addNewStudentResponse");
    private final static QName _DeleteStudentByIndeX_QNAME = new QName("http://lab.soa.agh.edu.pl/", "deleteStudentByIndeX");
    private final static QName _DeleteStudentByIndeXResponse_QNAME = new QName("http://lab.soa.agh.edu.pl/", "deleteStudentByIndeXResponse");
    private final static QName _DeleteStudentByName_QNAME = new QName("http://lab.soa.agh.edu.pl/", "deleteStudentByName");
    private final static QName _DeleteStudentByNameResponse_QNAME = new QName("http://lab.soa.agh.edu.pl/", "deleteStudentByNameResponse");
    private final static QName _GetBase64Avatar_QNAME = new QName("http://lab.soa.agh.edu.pl/", "getBase64Avatar");
    private final static QName _GetBase64AvatarResponse_QNAME = new QName("http://lab.soa.agh.edu.pl/", "getBase64AvatarResponse");
    private final static QName _GetStudentByAge_QNAME = new QName("http://lab.soa.agh.edu.pl/", "getStudentByAge");
    private final static QName _GetStudentByAgeResponse_QNAME = new QName("http://lab.soa.agh.edu.pl/", "getStudentByAgeResponse");
    private final static QName _GetStudentByIndex_QNAME = new QName("http://lab.soa.agh.edu.pl/", "getStudentByIndex");
    private final static QName _GetStudentByIndexResponse_QNAME = new QName("http://lab.soa.agh.edu.pl/", "getStudentByIndexResponse");
    private final static QName _GetStudentByName_QNAME = new QName("http://lab.soa.agh.edu.pl/", "getStudentByName");
    private final static QName _GetStudentByNameResponse_QNAME = new QName("http://lab.soa.agh.edu.pl/", "getStudentByNameResponse");
    private final static QName _GetStudents_QNAME = new QName("http://lab.soa.agh.edu.pl/", "getStudents");
    private final static QName _GetStudentsResponse_QNAME = new QName("http://lab.soa.agh.edu.pl/", "getStudentsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pl.egu.agh.soa.lab
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Student }
     * 
     */
    public Student createStudent() {
        return new Student();
    }

    /**
     * Create an instance of {@link GetStudentsResponse }
     * 
     */
    public GetStudentsResponse createGetStudentsResponse() {
        return new GetStudentsResponse();
    }

    /**
     * Create an instance of {@link GetStudentByNameResponse }
     * 
     */
    public GetStudentByNameResponse createGetStudentByNameResponse() {
        return new GetStudentByNameResponse();
    }

    /**
     * Create an instance of {@link GetStudentByAgeResponse }
     * 
     */
    public GetStudentByAgeResponse createGetStudentByAgeResponse() {
        return new GetStudentByAgeResponse();
    }

    /**
     * Create an instance of {@link AddNewStudent }
     * 
     */
    public AddNewStudent createAddNewStudent() {
        return new AddNewStudent();
    }

    /**
     * Create an instance of {@link AddNewStudentResponse }
     * 
     */
    public AddNewStudentResponse createAddNewStudentResponse() {
        return new AddNewStudentResponse();
    }

    /**
     * Create an instance of {@link DeleteStudentByIndeX }
     * 
     */
    public DeleteStudentByIndeX createDeleteStudentByIndeX() {
        return new DeleteStudentByIndeX();
    }

    /**
     * Create an instance of {@link DeleteStudentByIndeXResponse }
     * 
     */
    public DeleteStudentByIndeXResponse createDeleteStudentByIndeXResponse() {
        return new DeleteStudentByIndeXResponse();
    }

    /**
     * Create an instance of {@link DeleteStudentByName }
     * 
     */
    public DeleteStudentByName createDeleteStudentByName() {
        return new DeleteStudentByName();
    }

    /**
     * Create an instance of {@link DeleteStudentByNameResponse }
     * 
     */
    public DeleteStudentByNameResponse createDeleteStudentByNameResponse() {
        return new DeleteStudentByNameResponse();
    }

    /**
     * Create an instance of {@link GetBase64Avatar }
     * 
     */
    public GetBase64Avatar createGetBase64Avatar() {
        return new GetBase64Avatar();
    }

    /**
     * Create an instance of {@link GetBase64AvatarResponse }
     * 
     */
    public GetBase64AvatarResponse createGetBase64AvatarResponse() {
        return new GetBase64AvatarResponse();
    }

    /**
     * Create an instance of {@link GetStudentByAge }
     * 
     */
    public GetStudentByAge createGetStudentByAge() {
        return new GetStudentByAge();
    }

    /**
     * Create an instance of {@link GetStudentByIndex }
     * 
     */
    public GetStudentByIndex createGetStudentByIndex() {
        return new GetStudentByIndex();
    }

    /**
     * Create an instance of {@link GetStudentByIndexResponse }
     * 
     */
    public GetStudentByIndexResponse createGetStudentByIndexResponse() {
        return new GetStudentByIndexResponse();
    }

    /**
     * Create an instance of {@link GetStudentByName }
     * 
     */
    public GetStudentByName createGetStudentByName() {
        return new GetStudentByName();
    }

    /**
     * Create an instance of {@link GetStudents }
     * 
     */
    public GetStudents createGetStudents() {
        return new GetStudents();
    }

    /**
     * Create an instance of {@link Adres }
     * 
     */
    public Adres createAdres() {
        return new Adres();
    }

    /**
     * Create an instance of {@link pl.egu.agh.soa.lab.Courses }
     * 
     */
    public pl.egu.agh.soa.lab.Courses createCourses() {
        return new pl.egu.agh.soa.lab.Courses();
    }

    /**
     * Create an instance of {@link Articles }
     * 
     */
    public Articles createArticles() {
        return new Articles();
    }

    /**
     * Create an instance of {@link HomeTown }
     * 
     */
    public HomeTown createHomeTown() {
        return new HomeTown();
    }

    /**
     * Create an instance of {@link Student.Courses }
     * 
     */
    public Student.Courses createStudentCourses() {
        return new Student.Courses();
    }

    /**
     * Create an instance of {@link GetStudentsResponse.Students }
     * 
     */
    public GetStudentsResponse.Students createGetStudentsResponseStudents() {
        return new GetStudentsResponse.Students();
    }

    /**
     * Create an instance of {@link GetStudentByNameResponse.Students }
     * 
     */
    public GetStudentByNameResponse.Students createGetStudentByNameResponseStudents() {
        return new GetStudentByNameResponse.Students();
    }

    /**
     * Create an instance of {@link GetStudentByAgeResponse.Students }
     * 
     */
    public GetStudentByAgeResponse.Students createGetStudentByAgeResponseStudents() {
        return new GetStudentByAgeResponse.Students();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddNewStudent }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddNewStudent }{@code >}
     */
    @XmlElementDecl(namespace = "http://lab.soa.agh.edu.pl/", name = "addNewStudent")
    public JAXBElement<AddNewStudent> createAddNewStudent(AddNewStudent value) {
        return new JAXBElement<AddNewStudent>(_AddNewStudent_QNAME, AddNewStudent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddNewStudentResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddNewStudentResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://lab.soa.agh.edu.pl/", name = "addNewStudentResponse")
    public JAXBElement<AddNewStudentResponse> createAddNewStudentResponse(AddNewStudentResponse value) {
        return new JAXBElement<AddNewStudentResponse>(_AddNewStudentResponse_QNAME, AddNewStudentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteStudentByIndeX }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteStudentByIndeX }{@code >}
     */
    @XmlElementDecl(namespace = "http://lab.soa.agh.edu.pl/", name = "deleteStudentByIndeX")
    public JAXBElement<DeleteStudentByIndeX> createDeleteStudentByIndeX(DeleteStudentByIndeX value) {
        return new JAXBElement<DeleteStudentByIndeX>(_DeleteStudentByIndeX_QNAME, DeleteStudentByIndeX.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteStudentByIndeXResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteStudentByIndeXResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://lab.soa.agh.edu.pl/", name = "deleteStudentByIndeXResponse")
    public JAXBElement<DeleteStudentByIndeXResponse> createDeleteStudentByIndeXResponse(DeleteStudentByIndeXResponse value) {
        return new JAXBElement<DeleteStudentByIndeXResponse>(_DeleteStudentByIndeXResponse_QNAME, DeleteStudentByIndeXResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteStudentByName }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteStudentByName }{@code >}
     */
    @XmlElementDecl(namespace = "http://lab.soa.agh.edu.pl/", name = "deleteStudentByName")
    public JAXBElement<DeleteStudentByName> createDeleteStudentByName(DeleteStudentByName value) {
        return new JAXBElement<DeleteStudentByName>(_DeleteStudentByName_QNAME, DeleteStudentByName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteStudentByNameResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteStudentByNameResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://lab.soa.agh.edu.pl/", name = "deleteStudentByNameResponse")
    public JAXBElement<DeleteStudentByNameResponse> createDeleteStudentByNameResponse(DeleteStudentByNameResponse value) {
        return new JAXBElement<DeleteStudentByNameResponse>(_DeleteStudentByNameResponse_QNAME, DeleteStudentByNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBase64Avatar }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetBase64Avatar }{@code >}
     */
    @XmlElementDecl(namespace = "http://lab.soa.agh.edu.pl/", name = "getBase64Avatar")
    public JAXBElement<GetBase64Avatar> createGetBase64Avatar(GetBase64Avatar value) {
        return new JAXBElement<GetBase64Avatar>(_GetBase64Avatar_QNAME, GetBase64Avatar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBase64AvatarResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetBase64AvatarResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://lab.soa.agh.edu.pl/", name = "getBase64AvatarResponse")
    public JAXBElement<GetBase64AvatarResponse> createGetBase64AvatarResponse(GetBase64AvatarResponse value) {
        return new JAXBElement<GetBase64AvatarResponse>(_GetBase64AvatarResponse_QNAME, GetBase64AvatarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentByAge }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStudentByAge }{@code >}
     */
    @XmlElementDecl(namespace = "http://lab.soa.agh.edu.pl/", name = "getStudentByAge")
    public JAXBElement<GetStudentByAge> createGetStudentByAge(GetStudentByAge value) {
        return new JAXBElement<GetStudentByAge>(_GetStudentByAge_QNAME, GetStudentByAge.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentByAgeResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStudentByAgeResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://lab.soa.agh.edu.pl/", name = "getStudentByAgeResponse")
    public JAXBElement<GetStudentByAgeResponse> createGetStudentByAgeResponse(GetStudentByAgeResponse value) {
        return new JAXBElement<GetStudentByAgeResponse>(_GetStudentByAgeResponse_QNAME, GetStudentByAgeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentByIndex }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStudentByIndex }{@code >}
     */
    @XmlElementDecl(namespace = "http://lab.soa.agh.edu.pl/", name = "getStudentByIndex")
    public JAXBElement<GetStudentByIndex> createGetStudentByIndex(GetStudentByIndex value) {
        return new JAXBElement<GetStudentByIndex>(_GetStudentByIndex_QNAME, GetStudentByIndex.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentByIndexResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStudentByIndexResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://lab.soa.agh.edu.pl/", name = "getStudentByIndexResponse")
    public JAXBElement<GetStudentByIndexResponse> createGetStudentByIndexResponse(GetStudentByIndexResponse value) {
        return new JAXBElement<GetStudentByIndexResponse>(_GetStudentByIndexResponse_QNAME, GetStudentByIndexResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentByName }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStudentByName }{@code >}
     */
    @XmlElementDecl(namespace = "http://lab.soa.agh.edu.pl/", name = "getStudentByName")
    public JAXBElement<GetStudentByName> createGetStudentByName(GetStudentByName value) {
        return new JAXBElement<GetStudentByName>(_GetStudentByName_QNAME, GetStudentByName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentByNameResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStudentByNameResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://lab.soa.agh.edu.pl/", name = "getStudentByNameResponse")
    public JAXBElement<GetStudentByNameResponse> createGetStudentByNameResponse(GetStudentByNameResponse value) {
        return new JAXBElement<GetStudentByNameResponse>(_GetStudentByNameResponse_QNAME, GetStudentByNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudents }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStudents }{@code >}
     */
    @XmlElementDecl(namespace = "http://lab.soa.agh.edu.pl/", name = "getStudents")
    public JAXBElement<GetStudents> createGetStudents(GetStudents value) {
        return new JAXBElement<GetStudents>(_GetStudents_QNAME, GetStudents.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStudentsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://lab.soa.agh.edu.pl/", name = "getStudentsResponse")
    public JAXBElement<GetStudentsResponse> createGetStudentsResponse(GetStudentsResponse value) {
        return new JAXBElement<GetStudentsResponse>(_GetStudentsResponse_QNAME, GetStudentsResponse.class, null, value);
    }

}
