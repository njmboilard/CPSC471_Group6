# CPSC471_Group6

Guide to navigate project:

<b>NOTE: The password to access the document control section is "admin".</b>

<h3>BACKEND</h3>

<ul><li>Controller: Constraints REST controllers that define API endpoints. Handles HTTP requests and sends responses.</li>
<li>Dto (Data Transfer Objects): Contains Java objects used to transfer data between the application layers.</li>
<li>Entity: Contains JPA entity classes that map to database tables.</li>
<li>Exception: Contains custom exception classes for handling specific error scenarios.</li>
<li>Mapper: Includes classes responsible for mapping between entities and DTOs. Converts database models to API response formats and vice versa.</li>
<li>Repository: Contains Spring Data JPA repository interfaces for database access.</li>
<li>Service: Contains service classes that implement business logic.</li>
<li>BackendApplication.java: The main entry point of the Spring Boot application.</li></ul>

<h3>FULL-STACK/FRONTEND</h3>

<uL><li>The full-stack folder contains all the React and JS files related to the website/frontend. Under src is each of the .jsx and .js files used to create the website.</li>
<li>components → documentcontrol has each of the .jsx files for the document control section, for example listing regions (e.g. DC-ListRegion.jsx) and their subcomponents sections like subdivision, location and plan, as well as adding and updating (e.g. DC-Region.jsx)</li>
<li>components → read has each of the .jsx files for the reader section, for example listing regions (e.g. RD-ListSubdivision.jsx) and their subcomponents sections. However adding, updating and deleting is not allowed in this section.</li>
<li>src → services has the .js files for connecting to axios.</li>
<li>App.jsx has all the routing for the files in documentcontrol and region.</li></uL>
