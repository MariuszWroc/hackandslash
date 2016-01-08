module.controller('heroController', ['$scope', '$http', function($scope, $http){
    $scope.heroDetail = {};
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
            $scope.heroDetail = response;
        })
        .error(function(error){
            console.log("Error after getting hero. ", error);
        });
    
    function getHeroData(heroId) {
        $http.get(prefix + '/user/hero/get/' + heroId)
        .success(function(response){
            console.log('Fetching hero success ', response);
            $scope.heroDetail = response;
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
    
    function editHero() {
    	$http.put("user/hero/edit/"+$scope.heroDetail.id, $scope.heroDetail)
	    	.success(function(res){
	            console.log('is user logged? ',res);
	            $scope.heroDetail = res;
	        })
	        .error(function(error){
	            console.log('Error after getting user ' + error);
	        });
    };
    
    $scope.loadHero = function (heroId){
        getHeroData(heroId);
    }
    
    $scope.deleteHero = function(){
    	$http.delete("user/hero/delete/" + $scope.heroDetail.id)
	    	.success(function(res){
	            console.log('is user logged? ',res);
	            $scope.heroDetail = res;
	        })
	        .error(function(error){
	            console.log('Error after getting user ' + error);
	        });
    };
    
    $scope.submit = function(){
        if($scope.heroDetail.id) {
            editHero();
        } else {
            // dodać do add
            $http.post("user/hero/add/", $scope.heroDetail)
	    	.success(function(res){
	            console.log('is user logged? ',res);
	            $scope.heroDetail = res;
	        })
	        .error(function(error){
	            console.log('Error after getting user ' + error);
	        });
        }
    }
            
    $scope.reset = function(){
        getHeroData($scope.heroDetail.id);
    };
}]);