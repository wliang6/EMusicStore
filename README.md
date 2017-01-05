# EMusicStore
Building online music store from scratch!.. because <i>why not?</i>


<b>Frameworks</b>: Spring MVC, Spring Data, Spring Security, Spring REST, Spring Web Flow, Hibernate, Angular JS, JSP, Bootstrap, H2 Database and more

Front-end: HTML, CSS, Bootstrap, JSP, JavaScript, JQuery 

Back-end: Spring MVC, Spring Security, Spring Webflow 

Database: Spring Data, JPA, Hibernate, H2

Skills to obtain after completion of this Java Web Application:

- Use Spring MVC to implement MVC framework - <b><i>Complete</i></b>
- Use Bootstrap to quickly develop front-end view - <b><i>Complete</i></b>
- Develop domain classes to model the business entities - <b><i>Complete</i></b>
- Upload static resources such as images with the application - <b><i>Complete</i></b>
- Use Spring Data to integrate with Hibernate and JPA to persist model objects - <b><i>Complete</i></b>
- Use Spring Data, Hibernate or JPA for data validation - <b><i>Complete</i></b>
- Use Spring Security for login control
- Develop REST service APIs with Spring Framework
- Use Angular JS to consume REST services
- Use Spring Webflow to develop flow oriented web process, such as order checkout






<b>Bootstrap</b> is a front-end web framework used to design the e-music store website. 
Show page source to get code: http://getbootstrap.com/examples/carousel/#


The <b>JavaServer Pages Standard Tag Library (JSTL)</b> is a collection of useful <i>JSP tags</i> 
which encapsulates core functionality common to many JSP applications. 
JSTL Core tags provide support for iteration, conditional logic, catch exception, url, forward or redirect response etc.

JSTL tags expose information as JSP Expression Language variables like this : 
`<a href="<c:url value="/productList" />">Products</a></li>` 
or `<c:forEach items="${products}" var="product"> `


<b>H2 Database</b> is a Java SQL database that has a console that is browser based. It is a fast, open source, JDBC API and offers embedded and server modes.
http://h2database.com/html/main.html

<b>Spring Data JPA</b> stores and retrieves data in a relational database in a way that it eliminates boilerplate code. (It persists java object models into the database.) Example annotations used: @Entity indicates the our object class "Product" is an entity object in the table, @Id defines a unique primary key in table.

<b>Hibernate Validator</b> is used to validate the user-fields entered in "add product details" and "edit product details". Example annotations used: @NotEmpty(message = "") - field cannot be empty,  @Min(value=0, message = "") - field has to be over a certain min number.

<b>Spring Security</b> can be configured to provide login and logout capabilities and to check the authenticity of admin/users in an application. We would like to use our own login page and then delegate the request to spring login URL. 

![SpringSecurity](http://i64.tinypic.com/2lbzad.png)
