<%-- 
    Document   : ShowUsers
    Created on : Nov 28, 2015, 8:13:58 PM
    Author     : Jaca
--%>

<div ng-controller="registerController" flex id="content">
    <md-content layout="column" flex class="md-padding">
        <table style="width:100%">
            <tr>
              <td>Firstname</td>
              <td>{{userDetail.firstname}}</td>
            </tr>
            <tr>
              <td>Lastname</td>
              <td>{{userDetail.lastname}}</td>
            </tr>
            <tr>
              <td>Login</td>
              <td>{{userDetail.login}}</td>
            </tr>
            <tr>
              <td>Password</td>
              <td>{{userDetail.password}}</td>
            </tr>
            <tr>
              <td>Age</td>
              <td>{{userDetail.age}}</td>
            </tr>
            <tr>
              <td>Gender</td>
              <td>{{userDetail.gender}}</td>
            </tr>
        </table>
    </md-content>  
</div>