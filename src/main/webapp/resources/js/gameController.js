module.controller('gameController', ['$scope', '$http', function($scope, $http){
        
        $scope.backpackItems = [
            {
                id: 1,
                label:'Winged Helm',
                type: 'headgear'
            },
            {
                id: 2,
                label:'Bards Gloves',
                type: 'gloves'
            },
            {
                id: 3,
                label:'Bastard Sword',
                type: 'rightHand'
            },
            {
                id: 4,
                label:'Large Shield',
                type: 'leftHand'
            },
            {
                id: 5,
                label:'Ring of Protection +1',
                type: 'righRring'
            },
            {
                id: 6,
                label:'Gold Ring',
                type: 'leftRing'
            },
            {
                id: 7,
                label:'Plate armor',
                type: 'armor'
            },
            {
                id: 8,
                label:'Boots of speed',
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
            $scope.backpackItems = allItems;
        }
        
        $scope.removeItem = function (item) {
            console.log(item);
            /*
             * clear the cheroEcuipment item and then
             * restore it in the available list
             */
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