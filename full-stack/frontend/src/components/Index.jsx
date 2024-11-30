import React from 'react'
import {useNavigate} from "react-router-dom";

const Index = () => {

	const navigator = useNavigate();

	function reader() {
		navigator('/reader')
	}

	function documentController() {
		const userPassword = prompt('Enter Password');
		const requiredPassword = 'admin';

		if (userPassword === requiredPassword) {
			navigator('/documentcontrol')
		} else {
			alert('Incorrect Password. Access Denied.');
		}
	}

	return (
		<div>
			<div className='container'>
				<br/><br/><br/>
				<div className="row">
					<div className="card col-md-6 offset-md-3 offset-md-3">
						<button className="btn btn-dark mb-2" onClick={reader} style={{marginTop: '10px'}}>Reader</button>
						<button className="btn btn-dark mb-2" onClick={documentController} style={{marginTop: '10px'}}>Document Control</button>
					</div>
				</div>
			</div>
		</div>
	)
}
export default Index
