(function(){
	var app = angular.module('stockApp',[]);
	
	var controller = app.controller('stockController',function($scope,$http){
		$scope.as_of;
		$scope.reverse=true;
		$scope.customOrder='percent_change';
		
		$scope.getData = function(){
			var response = $http.get('/api/stocks').success(function(response){
				$scope.as_of = convertMilliToDate(response.as_of);
				$scope.stocks = response.stock;
				for(var i = 0; i < $scope.stocks.length; i++){
					$scope.stocks[i].volume = numberWithCommas($scope.stocks[i].volume);
				}
			});
		}
		
		$scope.orderBy = function(order){
			$scope.customOrder = order;
			$scope.reverse=!$scope.reverse;
		}

		//UTILITIES
		function convertMilliToDate(milli){
			var date = new Date(milli);
			return date.toLocaleString();
		}
		
		function numberWithCommas(x) {
		    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
		}

	});
})();