module.controller('gameController', ['$scope', '$http', function($scope, $http){
        $scope.backpackItems = [
            {
                id: 1,
                label:'item11',
                type: 'helmet'
            },
            {
                id: 2,
                label:'item1',
                type: 'glove'
            },
            {
                id: 3,
                label:'item2',
                type: 'mainHand'
            },
            {
                id: 4,
                label:'item3',
                type: 'offHand'
            },
            {
                id: 5,
                label:'item4',
                type: 'mainArmor'
            },
            {
                id: 6,
                label:'item5',
                type: 'boots'
            },
            {
                id: 7,
                label:'item6',
                type: 'helmet'
            },
            {
                id: 8,
                label:'item7',
                type: 'mainHand'
            },
            {
                id: 9,
                label:'item8',
                type: 'offHand'
            },
            {
                id: 10,
                label:'item9',
                type: 'mainArmor'
            },
            {
                id: 11,
                label:'item10',
                type: 'boots'
            },
        ];
	$scope.gloves = [];
        $scope.helmets = [];
        $scope.mainHands = [];
        $scope.offHands = [];
        $scope.mainArmors = [];
        $scope.bootsList = [];
        $scope.heroEquipment = {};
        
        filterItems();
        
        $scope.saveEquipment = function () {
            console.log('post user decision', $scope.heroEquipment);
        };
        
        $scope.reset = function () {
            $scope.heroEquipment = {};
        }
        
        $scope.$watch('backpackItems', function(value){
            filterItems();
        });
        
        function filterItems() {
            var regEx = new RegExp('glove');
            $scope.gloves = $scope.backpackItems.filter(function(value){
                return regEx.test(value.type);
            });
            
            regEx = new RegExp('mainHand');
            $scope.mainHands = $scope.backpackItems.filter(function(value){
                return regEx.test(value.type);
            });
            
            regEx = new RegExp('helmet');
            $scope.helmets = $scope.backpackItems.filter(function(value){
                return regEx.test(value.type);
            });
            
            regEx = new RegExp('offHand');
            $scope.offHands = $scope.backpackItems.filter(function(value){
                return regEx.test(value.type);
            });
            
            regEx = new RegExp('mainArmor');
            $scope.mainArmors = $scope.backpackItems.filter(function(value){
                return regEx.test(value.type);
            });
            
            regEx = new RegExp('boots');
            $scope.bootsList = $scope.backpackItems.filter(function(value){
                return regEx.test(value.type);
            });
        }
}]);