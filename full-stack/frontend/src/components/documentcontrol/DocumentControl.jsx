import React from 'react'
import {useNavigate} from "react-router-dom";

const DocumentControl = () => {

	const navigator = useNavigate();

	function DCListRegion() {
		navigator('/documentcontrol/regions')
	}

	function DCListProject() {
		navigator("/documentcontrol/projects");
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
						<button className="btn btn-dark mb-2" onClick={DCListRegion} 
							style={{marginTop: '10px'}}>Manage Regions
						</button>
						<button className="btn btn-dark mb-2" onClick={DCListProject}
						    style={{marginTop: '10px'}}>Manage Projects
						</button>
					</div>
				</div>
			</div>
		</div>
	)
}
export default DocumentControl
