module.controller('gameController', ['$scope', '$http', function($scope, $http){
        
        $scope.backpackItems = [
            {
                id: 1,
                label:'item11',
                type: 'headgear'
            },
            {
                id: 2,
                label:'item1',
                type: 'gloves'
            },
            {
                id: 3,
                label:'item2',
                type: 'leftHand'
            },
            {
                id: 12,
                label:'item2',
                type: 'righRring'
            },
            {
                id: 4,
                label:'item3',
                type: 'boot'
            },
            {
                id: 13,
                label:'item3',
                type: 'leftRing'
            },
            {
                id: 5,
                label:'item4',
                type: 'rightHand'
            },
            {
                id: 6,
                label:'item5',
                type: 'headgear'
            },
            {
                id: 7,
                label:'item6',
                type: 'headgear'
            },
            {
                id: 8,
                label:'item7',
                type: 'rightHand'
            },
            {
                id: 9,
                label:'item8',
                type: 'leftHand'
            },
            {
                id: 10,
                label:'item9',
                type: 'armor'
            },
            {
                id: 11,
                label:'item10',
                type: 'boot'
            },
        ];
	$scope.gloves = [];
        $scope.helmets = [];
        $scope.mainHands = [];
        $scope.offHands = [];
        $scope.mainArmors = [];
        $scope.bootsList = [];
        $scope.heroEquipment = {
        };
        
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
        
        $scope.watch('heroEquipment.mainHand', function(value) {
           mainHands.forEach(function(val, key) {
               if (val.id === value.id) {
                   mainHands.splice(key, 1);
               }
           }) 
        });
        
        function addQuickItem (item) {
            if ($scope.quickItems.length === 10) {
                //show allert
            } else {
                $scope.quickItems.push(item)
            }
        }
        
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