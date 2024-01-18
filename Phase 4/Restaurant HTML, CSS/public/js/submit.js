function submitForm(event) {
	
	event.preventDefault();
	document.querySelector('.book h1').style.display = 'none';
	document.querySelector('form').style.display = 'none';
	
	document.getElementById('thanks-message').style.display = 'block';
	
	document.getElementById('header').style.display = 'block';
	
	document.getElementById('footer').style.display = 'block';
}

