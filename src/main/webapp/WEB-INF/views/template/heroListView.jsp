<div class="panel panel-default">
    <!-- Default panel contents -->
    <div class="panel-heading">
            <span class="lead">List of Heroes </span>
            <button type="button" ng-click="initializeHero()"
                                                class="btn btn-success btn-sm floatRight">Create new</button>
    </div>
    <div class="tablecontainer">
            <table class="table table-hover">
                    <thead>
                            <tr>
                                    <th>ID.</th>
                                    <th>Name</th>
                                    <th width="20%"></th>
                            </tr>
                    </thead>
                    <tbody>
                            <tr ng-repeat="one_hero in heroes">
                                    <td><span ng-bind="one_hero.id"></span></td>
                                    <td><span ng-bind="one_hero.firstname"></span></td>
                                    <td>
                                            <button type="button" ng-click="loadHero(one_hero.id)"
                                                    class="btn btn-success custom-width">Edit</button>
                                            <button type="button" ng-click="deleteHero()"
                                                    class="btn btn-danger custom-width">Remove</button>
                                    </td>
                            </tr>
                    </tbody>
            </table>
    </div>
</div>