import React, {useEffect, useState} from 'react'
import {useNavigate, useParams} from "react-router-dom";
// more imports needed here

const DCContractDesigner = () => {

    const {id : projectId, cdid : contractDesignerId} = useParams();

    const [cdCompanyId, setCDCompanyId] = useState('')
	const [cdContractorName, setCDContractorName] = useState('')

	const [errors, setErrors] = useState({
	    cdCompanyId: '',
		cdContractorName: ''
	})

	const navigator = useNavigate();

	useEffect(() => {
		// commented out since getContractDesigner does not exist yet

		//if(contractDesignerId) {
		//	getProjectManager(contractDesignerId).then((response) => {
        //      setCDCompanyId(response.data.cdCompanyId);
		//		setCDContractorName(response.data.cdContractorName);
		//	}).catch(error => {
		//		console.error(error);
		//	})
		//}
	}, [contractDesignerId])

	function saveOrUpdateContractDesigner(e) {
		e.preventDefault();

		if (validateForm()) {
            
            const contractDesigner = {contractDesignerId, cdCompanyId, cdContractorName}

			console.log(issue)

			if (contractDesignerId) {
				// update contract designer

				// commented out since updateContractDesigner does not exist yet
				// not sure about parameters hence the (?)

				//updateContractDesigner( (?) ).then((response) => {
				//	console.log(response.data);
				//	navigator(`/documentcontrol/projects/${projectId}/personnel`);
				//}).catch(error => {
				//	console.error(error);
				//})
			} else {
				// add contract designer

				// commented out since createContractDesigner does not exist yet
				// not sure about parameters hence the (?)

				//createContractDesigner( (?) ).then((response) => {
				//	console.log(response.data);
				//	navigator(`/documentcontrol/projects/${projectId}/personnel`);
				//}).catch(errors => {
				//	console.error(errors);
				//})
			}
		}
	}

	function validateForm() {
		let valid = true;
		const errorsCopy = {... errors}

		if (cdCompanyId.trim()) {
			errorsCopy.cdCompanyId = '';
		} else {
			errorsCopy.cdCompanyId = 'Company ID is required';
			valid = false;
		}

		if (cdContractorName.trim()) {
			errorsCopy.cdContractorName = '';
		} else {
			errorsCopy.cdContractorName = 'Contractor Name is required';
			valid = false;
		}

		setErrors(errorsCopy);
		return valid;
	}

	function pageTitle() {
		if (contractDesignerId) {
			return <h2>Update Contract Designer</h2>
		} else {
			return <h2>Add Contract Designer</h2>
		}
	}

	function back(e) {
		e.preventDefault();
		navigator(`/documentcontrol/projects/${projectId}/personnel`);
	}

	return (
		<div className="container">
			<br/><br/><br/>
			<div className="row">
				<div className="card col-md-6 offset-md-3 offset-md-3">
					{pageTitle()}
					<div className="card-body">
						<form>
							<div className="form-group mb-3">
								<label className="form-label">Contract Designer Company ID</label>
								<input
									type="text"
									placeholder="Employee Name"
									name="companyId"    // is this supposed to be "Id" or "ID"?
									value={cdCompanyId}
									className={`form-control ${errors.cdCompanyId ? 'is-invalid' : ''}`}
									onChange={(e) => setCDCompanyId(e.target.value)}
								>
								</input>
								
								{errors.cdCompanyId && <div className="invalid-feedback">{errors.cdCompanyId}</div>}
							</div>
							<div className="form-group mb-3">
								<label className="form-label">Contract Designer Name</label>
								<input
									type="text"
									placeholder="Contractor Name"
									name="contractorName"
									value={cdContractorName}
									className={`form-control ${errors.cdContractorName ? 'is-invalid' : ''}`}
									onChange={(e) => setCDContractorName(e.target.value)}
								>
								</input>
								
								{errors.cdContractorName && <div className="invalid-feedback">{errors.cdContractorName}</div>}
							</div>
							<button className="btn btn-dark mb-2" onClick={saveOrUpdateContractDesigner}>Submit</button>
							<button className="btn btn-dark mb-2" onClick={back} style={{ marginLeft: '10px' }}>Back</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	)
}
export default DCContractDesigner