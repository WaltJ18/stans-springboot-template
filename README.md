# stans-springboot-template
My Template with command pattern

<h3>Module Description</h3>

<h4>Start module:</h4>
<ul>
  <li>WEB: Controllers, properties</li><br>
</ul>

<br>

<h4>Service module:</h4>
<ul>
  <li>COMMAND: core logic</li><br>
  <li>CLIENT: outbound call</li><br>
  <li>REPOSITORY: jpa database service</li><br>
  <li>REDIS: redis service</li><br>
</ul>

<br>

<h4>No dependency module:</h4>
<ul>
  <li>ENTITY: table database orm </li><br>
  <li>EXCEPTION: custom exception</li><br>
  <li>DOMAIN-CLIENT: DTOs for client only</li><br>
  <li>DOMAIN-COMMAND: DTOs for command only</li><br>
  <li>DOMAIN-WEB: DTOs for web only</li><br>
</ul>

<br>

<h3>Module Dependency</h3>
![img.png](documentation/img.png)