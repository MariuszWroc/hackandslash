<div  ng-controller="loginController" flex id="content">
    <md-content layout="column" flex class="md-padding">
        <form name="login" ng-submit="doLogin()" novalidate>
            <table>
                <tr>
                    <td>
                        <label>Login:</label>
                    </td>
                    <td>
                        <input type="text" ng-model="user.login"/>
                        <label ng-show="errors.login" class="error">{{errors.login}}</label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Password:</label>
                    </td>
                    <td>
                        <input type="password" ng-model="user.password"/>
                        <label ng-show="errors.password" class="error">{{errors.password}}</label>
                    </td>
                </tr>
            </table>
            <md-button class="md-raised" type="submit">Login</md-button>
        </form>
    </md-content>
</div>
