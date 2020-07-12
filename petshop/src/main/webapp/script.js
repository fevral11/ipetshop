'use strict'
let loginBtnOpen = document.querySelector('.login-btn__open');
let signUpBtnOpen = document.querySelector('.signUp-btn__open');

let loginBtnClose = document.querySelector('.modal-login__close');
let signUpBtnClose = document.querySelector('.modal-signUp__close');

let content = document.querySelector('.content');

let modalLogin = document.querySelector('.modal-login');
let modalSignUp = document.querySelector('.modal-signUp');

loginBtnOpen.addEventListener('click', function() {
	modalLogin.style.left = 100 + 'px';
	content.style.filter = 'blur(2px)';
	loginBtnOpen.style.color = '#ac1818';

})

loginBtnClose.addEventListener('click', function() {
	modalLogin.style.left = -190 + 'px';
	content.style.filter = '';
	loginBtnOpen.style.color = 'white';
})

signUpBtnOpen.addEventListener('click', function() {
	modalSignUp.style.left = 100 + 'px';
	content.style.filter = 'blur(2px)';
	signUpBtnOpen.style.color = '#ac1818';
})
signUpBtnClose.addEventListener('click', function() {
	modalSignUp.style.left = -190 + 'px';
	content.style.filter = '';
	signUpBtnOpen.style.color = 'white';
})