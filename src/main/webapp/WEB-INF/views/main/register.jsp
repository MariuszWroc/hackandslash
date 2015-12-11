<div  ng-controller="registerController" flex id="content">
            <md-content layout="column" flex class="md-padding">
                <form name="registration" ng-submit="doRegister()" >
                    <table>
                    <tr>
                        <tr>
                            <td>
                                <label>Login:</label>
                            </td>
                            <td>
                                <input type="text" ng-model="user.login"/>
                            </td>
                            <td>
                                <label ng-show="errors.login" class="error">{{errors.login}}</label>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="email">Email:</label>
                            </td>
                            <td>
                                <input type="text" id="email" ng-model="user.email"/>
                            </td>
                            <td>
                                <label ng-show="errors.email" class="error">{{errors.email}}</label>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Password:</label>
                            </td>
                            <td>
                                <input type="password" ng-model="user.password"/>
                            </td>
                            <td>
                                <label ng-show="errors.password" class="error">{{errors.password}}</label>
                            </td>
                        </tr>
	            		<tr>
	                    	<td>
                                <label>Firstname:</label>
                            </td>
                            <td>
                                <input type="text" ng-model="user.firstname"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Lastname:</label>
                            </td>
                            <td>
                               <input type="text" ng-model="user.lastname"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Age:</label>
                            </td>
                            <td>
                                <input type="number" min="1" max="99" ng-model="user.age"/>
                            </td>
                            <td>
                                <label ng-show="errors.password" class="error">{{errors.password}}</label>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Gender:</label>
                            </td>
                            <td>
                                <md-input-container style="margin-right: 10px;">
                                    <md-select ng-model="user.gender">
                                        <md-option ng-repeat="gender in genders" value="{{gender.id}}">{{gender.name}}</md-option>
                                    </md-select>
                                </md-input-container>
                            </td>
                            <td>
                                <label ng-show="errors.password" class="error">{{errors.password}}</label>
                            </td>
                        </tr>
                    </table>
                    <md-button class="md-raised" type="submit">Register</md-button>
                    <md-button class="md-raised" type="button" ng-click="clear()">Clear</md-button>
                </form>
            </md-content>
        </div>