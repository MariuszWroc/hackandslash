module.controller('heroController', ['$scope', '$http', function($scope, $http){
    
    function initializeHero(){
        $scope.heroDetail = {
            'firstname': '',
            'lastname': '',
            'gender': 0,
            'age': 0,
            'race': 0,
            'profession': 0,
            'strength': 0,
            'dexterity': 0,
            'constitution': 0,
            'intelligence': 0,
            'charisma': 0,
            'baseHP': 0
        };
    }
    
    initializeHero();
    
    $scope.heroes = [];
    
    $scope.genders = [
                      { id: 1, label: 'Male' },
                      { id: 2, label: 'Female' },
                      ];
    
    $scope.races = [
                      { id: 1, label: 'Human' },
                      { id: 2, label: 'Elf' },
                      { id: 3, label: 'Dwarf' },
                      { id: 4, label: 'Halfling' },
                      ];
    
    $scope.proffesions = [
                      { id: 1, label: 'Mage' },
                      { id: 2, label: 'Warrior' },
                      { id: 3, label: 'Ranger' },
                      { id: 4, label: 'Thief' },
                      ];
                      
    $http.get(prefix + '/user/actualHero')
        .success(function(response){
            console.log('Fetching hero success ', response);
            if(response){
                $scope.heroDetail = response;
            } else {
                initializeHero();
            }
        })
        .error(function(error){
            console.log("Error after getting hero. ", error);
        });
    
    function getHeroData(heroId) {
        $http.get(prefix + '/user/hero/get/' + heroId)
        .success(function(response){
            console.log('Fetching hero success ', response);
            if(response){
                $scope.heroDetail = response;
            } else {
                initializeHero();
            }
        })
        .error(function(error){
            console.log("Error after getting hero. ", error);
        });
    }
    
    $http.get(prefix + '/user/hero/getAll')
	    .success(function(response){
	    console.log('Fetching hero success ', response);
	        $scope.heroes = response;
	    })
	    .error(function(error){
	        console.log("Error after getting hero. ", error);
	    });
            
    function setErrors(error){
        console.log(error);
        if(error.length>0) {
            if(!$scope.errors){
                    $scope.errors = []
                }
            angular.forEach(error, function(val){
                if(val.field==='age'){
                    $scope.errors.age = val.defaultMessage;
                }
                if(val.field==='constitution'){
                    $scope.errors.constitution = val.defaultMessage;
                }
                if(val.field==='charisma'){
                    $scope.errors.charisma = val.defaultMessage;
                }
                if(val.field==='intelligence'){
                    $scope.errors.intelligence = val.defaultMessage;
                }
                if(val.field==='firstname'){
                    $scope.errors.firstname = val.defaultMessage;
                }
                if(val.field==='dexterity'){
                    $scope.errors.dexterity = val.defaultMessage;
                }
                if(val.field==='strength'){
                    $scope.errors.strength = val.defaultMessage;
                }
            });
        } else {
            console.log('Error trying to update hero ' + error);
        }
    }
    
    function editHero() {
    	$http.put("user/hero/edit/"+$scope.heroDetail.id, $scope.heroDetail)
	    	.success(function(res){
	            console.log('is user logged? ',res);
	            if(res){
                        $scope.heroDetail = res;
                    } else {
                        initializeHero();
                    }
	        })
	        .error(function(error){
	            setErrors(error);
	        });
    };
    
    $scope.loadHero = function (heroId){
        getHeroData(heroId);
    }
    
    $scope.deleteHero = function(){
    	$http.delete("user/hero/delete/" + $scope.heroDetail.id)
	    	.success(function(res){
	            console.log('is user logged? ',res);
	            if(res){
                        $scope.heroDetail = res;
                    } else {
                        initializeHero();
                    }
                    $http.get(prefix + '/user/hero/getAll')
                    .success(function(response){
                        console.log('Fetching hero success ', response);
                        $scope.heroes = response;
                    })
                    .error(function(error){
                        console.log("Error after getting hero. ", error);
                    });
	        })
	        .error(function(error){
	            console.log('Error trying to update hero ' + error);
	        });
    };
    
    $scope.submit = function(){
        if($scope.heroDetail.id) {
            editHero();
        } else {
            console.log($scope.heroDetail);
            $http.post("user/hero/add", $scope.heroDetail)
	    	.success(function(res){
	            console.log('is user logged? ',res);
	            if(res){
                        $scope.heroDetail = res;
                    } else {
                        initializeHero();
                    }
	        })
	        .error(function(error){
	            setErrors(error);
	        });
        }
    }
            
    $scope.reset = function(){
        getHeroData($scope.heroDetail.id);
    };
}]);