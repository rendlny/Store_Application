/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function menuRotate(x) {
    x.classList.toggle("change");
}

//Loads this script straight away when the page is ready
$(document).ready(function(){
	//Set the menu to open when page is loaded
	$click = 0;
	
	//when the trigger is clicked this code block is run
	$(".container").click(function(){
		//if menu is closed ($click = 0) open menu 
		if($click == 0)
		{
			$(".slider").animate({left: '0px'});
			$click = 1;
		}
		//else if menu is open ($click = 1) close menu 
		else
		{
			$(".slider").animate({left: '-250px'});
			$click = 0;
		}
  });
});