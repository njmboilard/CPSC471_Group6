import React from 'react'
import RDListRegion from "./RD-ListRegion.jsx";
import {useNavigate} from "react-router-dom";

const Reader = () => {
	const navigator = useNavigate();

	function RDListRegion() {
		navigator("/reader/regions");
	}

	return (
		<div>
			<div className='container'>
				<br/><br/><br/>
				<div className="row">
					<div className="card col-md-6 offset-md-3 offset-md-3">
						<button className="btn btn-dark mb-2" onClick={RDListRegion}
						        style={{marginTop: '10px'}}>Regions
						</button>
					</div>
				</div>
			</div>
		</div>
	)
}
export default Reader
