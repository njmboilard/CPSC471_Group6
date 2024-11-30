import React from 'react'
import {useNavigate} from "react-router-dom";

const DocumentControl = () => {

	const navigator = useNavigate();

	function DCListRegion() {
		navigator('/documentcontrol/regions')
	}

	return (
		<div>
			<div className='container'>
				<br/><br/><br/>
				<div className="row">
					<div className="card col-md-6 offset-md-3 offset-md-3">
						<button className="btn btn-dark mb-2" onClick={DCListRegion} style={{marginTop: '10px'}}>Regions</button>
					</div>
				</div>
			</div>
		</div>
	)
}
export default DocumentControl
