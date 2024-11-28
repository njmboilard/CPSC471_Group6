import React from 'react'
import {useNavigate} from "react-router-dom";

const DCIndex = () => {

	const navigator = useNavigate();

	function DCListRegion() {
		navigator('/dc-regions')
	}

	function DCListSubdivision() {
		navigator('/dc-subdivisions')
	}

	function DCListLocation() {
		navigator('/dc-locations')
	}

	function DCListPlan() {
		navigator('/dc-plans')
	}

	function DCListProject() {
		navigator('/dc-projects')
	}

	return (
		<div>
			<div className='container'>
				<br/><br/><br/>
				<div className="row">
					<div className="card col-md-6 offset-md-3 offset-md-3">
						<button className="btn btn-dark mb-2" onClick={DCListRegion} style={{marginTop: '10px'}}>Regions</button>
						<button className="btn btn-dark mb-2" onClick={DCListSubdivision} style={{marginTop: '10px'}}>Subdivisions</button>
						<button className="btn btn-dark mb-2" onClick={DCListLocation} style={{marginTop: '10px'}}>Locations</button>
						<button className="btn btn-dark mb-2" onClick={DCListPlan} style={{marginTop: '10px'}}>Plans</button>
						<button className="btn btn-dark mb-2" onClick={DCListProject} style={{marginTop: '10px'}}>Projects</button>
					</div>
				</div>
			</div>
		</div>
	)
}
export default DCIndex
