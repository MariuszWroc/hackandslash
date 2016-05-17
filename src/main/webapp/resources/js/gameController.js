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
        
        $scope.journal = {
            id: 15002900,
            questList: [
            {
                description:'Quest 1',
                assignmentList:[
                    {
                        description: 'Quest 1 Assigment 1 description',
                        target: 'Quest 1 Assigment 1 target',
                        place: {
                            latitude: 125,
                            longitude: 125,
                            radius: 50
                        }
                    },
                    {
                        description: 'Quest 1 Assigment 2 description',
                        target: 'Quest 1 Assigment 2 target',
                        place: {
                            latitude: 125,
                            longitude: 125,
                            radius: 50
                        }
                    },
                    {
                        description: 'Quest 1 Assigment 3 description',
                        target: 'Quest 1 Assigment 3 target',
                        place: {
                            latitude: 125,
                            longitude: 125,
                            radius: 50
                        }
                    }
                ]
            },
            {
                description:'Quest 2',
                assignmentList:[
                    {
                        description: 'Quest 2 Assigment 1 description',
                        target: 'Quest 2 Assigment 1 target',
                        place: {
                            latitude: 125,
                            longitude: 125,
                            radius: 50
                        }
                    },
                    {
                        description: 'Quest 2 Assigment 2 description',
                        target: 'Quest 2 Assigment 2 target',
                        place: {
                            latitude: 125,
                            longitude: 125,
                            radius: 50
                        }
                    },
                    {
                        description: 'Quest 2 Assigment 3 description',
                        target: 'Quest 2 Assigment 3 target',
                        place: {
                            latitude: 125,
                            longitude: 125,
                            radius: 50
                        }
                    }
                ]
            },
            {
                description:'Quest 3',
                assignmentList:[
                    {
                        description: 'Quest 3 Assigment 1 description',
                        target: 'Quest 3 Assigment 1 target',
                        place: {
                            latitude: 125,
                            longitude: 125,
                            radius: 50
                        }
                    },
                    {
                        description: 'Quest 3 Assigment 2 description',
                        target: 'Quest 3 Assigment 2 target',
                        place: {
                            latitude: 125,
                            longitude: 125,
                            radius: 50
                        }
                    },
                    {
                        description: 'Quest 3 Assigment 3 description',
                        target: 'Quest 3 Assigment 3 target',
                        place: {
                            latitude: 125,
                            longitude: 125,
                            radius: 50
                        }
                    }
                ]
            }
        ]
        };
        
        $scope.sellectedQuest = {};
        
        $scope.questSelect = function(quest) {
            $scope.sellectedQuest = quest
        }
        
        $scope.abandonQuest = function(id) {
            $scope.journal.questList.splice(id,1);
        }
        
        $scope.restoreView = function() {
            $scope.journal.questList = [
            {
                description:'Quest 1',
                assignmentList:[
                    {
                        description: 'Quest 1 Assigment 1 description',
                        target: 'Quest 1 Assigment 1 target',
                        place: {
                            latitude: 125,
                            longitude: 125,
                            radius: 50
                        }
                    },
                    {
                        description: 'Quest 1 Assigment 2 description',
                        target: 'Quest 1 Assigment 2 target',
                        place: {
                            latitude: 125,
                            longitude: 125,
                            radius: 50
                        }
                    },
                    {
                        description: 'Quest 1 Assigment 3 description',
                        target: 'Quest 1 Assigment 3 target',
                        place: {
                            latitude: 125,
                            longitude: 125,
                            radius: 50
                        }
                    }
                ]
            },
            {
                description:'Quest 2',
                assignmentList:[
                    {
                        description: 'Quest 2 Assigment 1 description',
                        target: 'Quest 2 Assigment 1 target',
                        place: {
                            latitude: 125,
                            longitude: 125,
                            radius: 50
                        }
                    },
                    {
                        description: 'Quest 2 Assigment 2 description',
                        target: 'Quest 2 Assigment 2 target',
                        place: {
                            latitude: 125,
                            longitude: 125,
                            radius: 50
                        }
                    },
                    {
                        description: 'Quest 2 Assigment 3 description',
                        target: 'Quest 2 Assigment 3 target',
                        place: {
                            latitude: 125,
                            longitude: 125,
                            radius: 50
                        }
                    }
                ]
            },
            {
                description:'Quest 3',
                assignmentList:[
                    {
                        description: 'Quest 3 Assigment 1 description',
                        target: 'Quest 3 Assigment 1 target',
                        place: {
                            latitude: 125,
                            longitude: 125,
                            radius: 50
                        }
                    },
                    {
                        description: 'Quest 3 Assigment 2 description',
                        target: 'Quest 3 Assigment 2 target',
                        place: {
                            latitude: 125,
                            longitude: 125,
                            radius: 50
                        }
                    },
                    {
                        description: 'Quest 3 Assigment 3 description',
                        target: 'Quest 3 Assigment 3 target',
                        place: {
                            latitude: 125,
                            longitude: 125,
                            radius: 50
                        }
                    }
                ]
            }
        ]
        }
        
        $scope.shop = [
            {
                id: 0,
                label: 'item 0',
                price: 10,
                type: 'headgear'
            },
            {
                id: 1,
                label: 'item 1',
                price: 20,
                type: 'headgear'
            },
            {
                id: 2,
                label: 'item 2',
                price: 30,
                type: 'headgear'
            },
            {
                id: 3,
                label: 'item 3',
                price: 40,
                type: 'headgear'
            },
            {
                id: 4,
                label: 'item 4',
                price: 50,
                type: 'headgear'
            },
            {
                id: 5,
                label: 'item 5',
                price: 60,
                type: 'headgear'
            },
            {
                id: 6,
                label: 'item 6',
                price: 70,
                type: 'headgear'
            },
            {
                id: 7,
                label: 'item 7',
                price: 80,
                type: 'headgear'
            },
            {
                id: 8,
                label: 'item 8',
                price: 90,
                type: 'headgear'
            },
            {
                id: 9,
                label: 'item 9',
                price: 100,
                type: 'headgear'
            },
        ];
        
        $scope.bought = [];
        $scope.cash = 1000;
        
        $scope.buy = function(id) {
            if ($scope.cash>=$scope.shop[id].price) {
                $scope.bought.push(angular.copy($scope.shop[id]));
                $scope.cash -= $scope.shop[id].price;
                $scope.shop.splice(id, 1);
            }
        }
        
        $scope.sellBack = function(index) {
            $scope.shop.splice($scope.bought[index].id, 0, angular.copy($scope.bought[index]));
            $scope.cash += $scope.bought[index].price;
            $scope.bought.splice(index, 1);
        }
        
        $scope.restoreShop = function() {
            $scope.shop = [
            {
                id: 0,
                label: 'item 0',
                price: 10,
                type: 'headgear'
            },
            {
                id: 1,
                label: 'item 1',
                price: 20,
                type: 'headgear'
            },
            {
                id: 2,
                label: 'item 2',
                price: 30,
                type: 'headgear'
            },
            {
                id: 3,
                name: 'item 3',
                price: 40,
                type: 'headgear'
            },
            {
                id: 4,
                name: 'item 4',
                price: 50,
                type: 'headgear'
            },
            {
                id: 5,
                name: 'item 5',
                price: 60,
                type: 'headgear'
            },
            {
                id: 6,
                name: 'item 6',
                price: 70,
                type: 'headgear'
            },
            {
                id: 7,
                name: 'item 7',
                price: 80,
                type: 'headgear'
            },
            {
                id: 8,
                name: 'item 8',
                price: 90,
                type: 'headgear'
            },
            {
                id: 9,
                name: 'item 9',
                price: 100,
                type: 'headgear'
            },
        ]
        }
}]);