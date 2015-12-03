'use strict';
 
App.factory('UserService', ['$http', '$q', function($http, $q){
 
    return {
         
            createUser: function(user){
                    return $http.post('/user/', user)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while creating user');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
            
            readUser: function() {
                return $http.get('/user/')
                        .then(
                                function(response){
                                    return response.data;
                                }, 
                                function(errResponse){
                                    console.error('Error while fetching users');
                                    return $q.reject(errResponse);
                                }
                        );
            },
             
            updateUser: function(user, login){
                    return $http.put('/user/'+login, user)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while updating user');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
//            deleteUser: function(id){
//                    return $http.delete('/user/'+id)
//                            .then(
//                                    function(response){
//                                        return response.data;
//                                    }, 
//                                    function(errResponse){
//                                        console.error('Error while deleting user');
//                                        return $q.reject(errResponse);
//                                    }
//                            );
//            }
         
    };
 
}]);