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
              <td>user.firstname</td>
              <td>user.lastname</td>
              <td>user.login</td>
              <td>user.password</td>
              <td>user.age</td>
              <td>user.gender</td>
            </tr>
        </table>
    </md-content>  
</div>