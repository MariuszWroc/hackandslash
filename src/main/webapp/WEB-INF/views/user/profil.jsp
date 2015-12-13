<%-- 
    Document   : Profl
    Created on : Nov 28, 2015, 8:13:58 PM
    Author     : Jaca
--%>

<div ng-controller="userController" flex id="content">
    <md-content layout="column" flex class="md-padding">
        <table style="width:100%">
            <tr>
              <td>
              	<label>Firstname</label>
              </td>
              <td>{{userDetail.firstname}}</td>
            </tr>
            <tr>
              <td>
              	<label>Lastname</label>
              </td>
              <td>{{userDetail.lastname}}</td>
            </tr>
            <tr>
              <td>
              	<label>Login</label>
              </td>
              <td>{{userDetail.login}}</td>
            </tr>
            <tr>
              <td>
              	<label>Age</label>
              </td>
              <td>{{userDetail.age}}</td>
            </tr>
            <tr>
              <td>
              	<label>Gender</label>
              </td>
              <td>{{userDetail.gender}}</td>
            </tr>
        </table>
    </md-content>  
</div>