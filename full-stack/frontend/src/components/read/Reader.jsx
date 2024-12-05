import React from 'react'
import RDListRegion from "./RD-ListRegion.jsx";
import {useNavigate} from "react-router-dom";
import RdListProject from './RD-ListProject.jsx';

const Reader = () => {
	const navigator = useNavigate();

	function RDListRegion() {
		navigator("/reader/regions");
	}

	function RDListProject() {
		navigator("/reader/projects");
	}

	function back() {
		navigator(`/`);
	}

	return (
		<div>
			<div className='container'>
				<br/><br/><br/>
				<div className="row">
    				<div className="col-md-12 text-center mb-3">
      					<button className="btn btn-dark mb-2" onClick={back}>Back</button>
    				</div>
  				</div>
				<div className="row">
					<div className="card col-md-6 offset-md-3 offset-md-3">
						<button className="btn btn-dark mb-2" onClick={RDListRegion}
						        style={{marginTop: '10px'}}>Regions
						</button>
						<button className="btn btn-dark mb-2" onClick={RDListProject}
						        style={{marginTop: '10px'}}>Projects
						</button>
					</div>
				</div>
			</div>
		</div>
	)
}
export default Reader
