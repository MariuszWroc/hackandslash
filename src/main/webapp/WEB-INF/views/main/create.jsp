<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<c:set var="contextPath" value="${pageContext.request.contextPath}" />
		<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/home.css">
	</head>
	<body>
		<div  ng-controller="registerController" flex id="content" ng-cloak class="ng-cloak">
		            <md-content layout="column" flex class="md-padding">
		                <form name="registration" ng-submit="doRegister()" novalidate> <!-- ng-submit="doRegister()"-->
		                    <table>
			            	<tr>
			                    <td>
		                                <label>Firstname:</label>
		                            </td>
		                            <td>
		                                <input type="text" ng-model="hero.firstname"/>
		                            </td>
		                        </tr>
		                        <tr>
		                            <td>
		                                <label>Lastname:</label>
		                            </td>
		                            <td>
		                               <input type="text" ng-model="hero.lastname"/>
		                            </td>
		                        </tr>
		                        <tr>
		                            <td>
		                                <label>Age:</label>
		                            </td>
		                            <td>
		                                <input type="number" ng-model="hero.age"/>
		                            </td>
		                        </tr>
		                        <tr>
		                            <td>
		                                <label>Gender:</label>
		                            </td>
		                            <td>
		                                <md-input-container style="margin-right: 10px;">
		                                    <md-select ng-model="hero.gender">
		                                        <md-option ng-repeat="gender in genders" value="{{gender.id}}">{{gender.name}}</md-option>
		                                    </md-select>
		                                </md-input-container>
		                            </td>
		                        </tr>
		                        <tr>
		                            <td>
		                                <label>Race:</label>
		                            </td>
		                            <td>
		                                <md-input-container style="margin-right: 10px;">
		                                    <md-select ng-model="hero.race">
		                                        <md-option ng-repeat="race in races" value="{{race.id}}">{{race.name}}</md-option>
		                                    </md-select>
		                                </md-input-container>
		                                <!--<label ng-show="errors.email" class="error">{{errors.email}}</label>-->
		                            </td>
		                        </tr>
		                        </table>
		                        <table ng-show="hero.race">
		                            <tr>
		                                <td>
		                                    <label>Profession</label>
		                                </td>
		                                <td>
		                                    <md-input-container style="margin-right: 10px;">
		                                        <md-select ng-model="hero.profession">
		                                            <md-option ng-repeat="profession in professions" value="{{profession.id}}">{{profession.name}}</md-option>
		                                        </md-select>
		                                    </md-input-container>
		                                    <!--<label ng-show="errors.login" class="error">{{errors.login}}</label>-->
		                                </td>
		                            </tr>
		                        </table>
		                        <table ng-show="hero.profession">
		                            <tr>
		                                <td>
		                                    <label>Strength:</label>
		                                </td>
		                                <td>
		                                    <input type="number" ng-model="hero.strength"/>
		                                    <!--<label ng-show="errors.password" class="error">{{errors.password}}</label>-->
		                                </td>
		                            </tr>
		                            <tr>
		                                <td>
		                                    <label>Dexterity:</label>
		                                </td>
		                                <td>
		                                    <input type="number" ng-model="hero.dexterity"/>
		                                    <!--<label ng-show="errors.password" class="error">{{errors.password}}</label>-->
		                                </td>
		                            </tr>
		                            <tr>
		                                <td>
		                                    <label>Constitution:</label>
		                                </td>
		                                <td>
		                                    <input type="number" ng-model="hero.constitution"/>
		                                    <!--<label ng-show="errors.password" class="error">{{errors.password}}</label>-->
		                                </td>
		                            </tr>
		                            <tr>
		                                <td>
		                                    <label>Intelligence:</label>
		                                </td>
		                                <td>
		                                    <input type="number" ng-model="hero.intelligence"/>
		                                    <!--<label ng-show="errors.password" class="error">{{errors.password}}</label>-->
		                                </td>
		                            </tr>
		                            <tr>
		                                <td>
		                                    <label>Charisma:</label>
		                                </td>
		                                <td>
		                                    <input type="number" ng-model="hero.charisma"/>
		                                    <!--<label ng-show="errors.password" class="error">{{errors.password}}</label>-->
		                                </td>
		                            </tr>
		                            <tr>
		                                <td>
		                                    <label>Atribute points</label>
		                                </td>
		                                <td>
		                                    <label>10</label>
		                                    <!--<label ng-show="errors.password" class="error">{{errors.password}}</label>-->
		                                </td>
		                            </tr>
		                    </table>
		<!--                    <md-button class="md-raised" type="submit">Create</md-button>
		                    <md-button class="md-raised" type="button" ng-click="clear()">Clear</md-button>
		                    <md-button class="md-raised" type="button" ng-click="Reroll()">Roll again</md-button>-->
		                </form>
		            </md-content>
		        </div>
	</body>
</html>