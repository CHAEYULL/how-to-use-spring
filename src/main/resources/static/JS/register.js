function register(){
 	fetch(`/register`,{
		method :'POST',
		headers :{'Content-Type': 'application/json'},
		body : JSON.stringify({
			username : document.querySelector('#username').value,
			displayName : document.querySelector('#displayName').value,
			password : 	document.querySelector('#password').value
		})
	})
	.then((r)=>{return r.text()})
	.then((r)=>{
		location.replace('/')
	})
	.catch((e)=>{
		console.log(`에러남 ${e}`);
	}) 
}