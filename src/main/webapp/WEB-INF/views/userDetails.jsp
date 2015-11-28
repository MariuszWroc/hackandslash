<%-- 
    Document   : ShowUsers
    Created on : Nov 28, 2015, 8:13:58 PM
    Author     : Jaca
--%>

<div ng-controller="registerController" flex id="content">
    <md-content layout="column" flex class="md-padding">
        <table style="width:100%">
            <tr>
              <th>Firstname</th>
              <th>Lastname</th> 
              <th>Login</th>
              <th>Password</th>
              <th>Age</th> 
              <th>Gender</th>
            </tr>
            <tr>
              <td>{{userDetail.firstname}}</td>
              <td>{{userDetail.lastname}}</td>
              <td>{{userDetail.login}}</td>
              <td>{{userDetail.password}}</td>
              <td>{{userDetail.age}}</td>
              <td>{{userDetail.gender}}</td>
            </tr>
        </table>
    </md-content>  
</div>