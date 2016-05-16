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
        
        var allItems = $scope.backpackItems;

        $scope.heroEquipment = {
        };
        
        filterItems();
        
        $scope.saveEquipment = function () {
            console.log('post user decision', $scope.heroEquipment);
        };
        
        $scope.reset = function () {
            $scope.heroEquipment = {};
        }
        
//        $scope.$watch('backpackItems', function(value){
//            $scope.backpackItems = allItems;
//            filterItems();
//        });
        
        $scope.selectItem = function (item) {
            $scope.heroEquipment[item.type] = item;
            $scope.backpackItems = allItems;
            filterItems();
        };
        
        function addQuickItem (item) {
            if ($scope.quickItems.length === 10) {
                //show allert
            } else {
                $scope.quickItems.push(item)
            }
        }
        
        $scope.filterTable = function () {
            $scope.backpackItems = allItems;
            if($scope.filterType) {
                if($scope.filterType !== 'all') {
                    filterItems();
                    $scope.backpackItems = $scope.backpackItems.filter(function(element, index, array) {
                        return (element.type===$scope.filterType);
                    });
                }
            }
        };
        
        function filterItems() {
            for(key in $scope.heroEquipment) {
                if($scope.heroEquipment[key] && $scope.heroEquipment[key].id) {
                    $scope.backpackItems = $scope.backpackItems.filter(function(element, index, array) {
                        return (element.id!=$scope.heroEquipment[key].id);
                    });
                }
            }
        }
}]);