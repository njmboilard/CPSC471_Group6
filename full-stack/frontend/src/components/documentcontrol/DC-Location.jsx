import React, {useEffect, useState} from 'react'
import {useNavigate, useParams} from "react-router-dom";
// more imports needed here

const DCLocation = () => {
	const [locationMileage, setLocationMileage] = useState('')
	const [locationType, setLocationType] = useState('')
    const [locationName, setLocationName] = useState('')
	const {id : regionId, chopcode : chopCode, mileage} = useParams();

	const [errors, setErrors] = useState({
		locationMileage: '',
		locationType: '',
        locationName: ''
	})

	const navigator = useNavigate();

	useEffect(() => {
		// commented out since getLocation does not exist yet
        // not sure about parameters hence the (?)

		//if(mileage) {
		//	getLocation( (?) ).then((response) => {
		//		setLocationMileage(response.data.locationMileage);
		//		setLocationType(response.data.locationType);
        //		setLocationName(response.data.locationName);
		//	}).catch(error => {
		//		console.error(error);
		//	})
		//}
	}, [mileage])

	function saveOrUpdateLocation(e) {
		e.preventDefault();

		if (validateForm()) {

			const location = {chopCode, locationMileage, locationType, locationName}
			console.log(location)

			if (mileage) {
				// update location

				// commented out since updateLocation does not exist yet
				// not sure about parameters hence the (?)

				//updateLocation( (?) ).then((response) => {
				//	console.log(response.data);
				//	navigator(`/documentcontrol/regions/${regionId}/subdivisions/${chopCode}/locations`);
				//}).catch(error => {
				//	console.error(error);
				//})
			} else {
				// add location

				// commented out since createLocation does not exist yet
				// not sure about parameters hence the (?)

				//createLocation( (?) ).then((response) => {
				//	console.log(response.data);
				//	navigator(`/documentcontrol/regions/${regionId}/subdivisions/${chopCode}/locations`);
				//}).catch(errors => {
				//	console.error(errors);
				//})
			}
		}
	}

	function validateForm() {
		let valid = true;
		const errorsCopy = {... errors}

		if (locationMileage.trim()) {
			errorsCopy.locationMileage = '';
		} else {
			errorsCopy.locationMileage = 'Mileage is required';
			valid = false;
		}

		if (locationType.trim()) {
			errorsCopy.locationType = '';
		} else {
			errorsCopy.locationType = 'Location Type is required';
			valid = false;
		}

        if (locationName.trim()) {
			errorsCopy.locationName = '';
		} else {
			errorsCopy.locationName = 'Location Name is required';
			valid = false;
		}

		setErrors(errorsCopy);
		return valid;
	}

	function pageTitle() {
		if (mileage) {
			return <h2>Update Location</h2>
		} else {
			return <h2>Add Location</h2>
		}
	}

	function back(e) {
		e.preventDefault();
		navigator(`/documentcontrol/regions/${regionId}/subdivisions/${chopCode}/locations`);
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
								<label className="form-label">Mileage</label>
								<input
									type="text"
									placeholder="Mileage"
									name="mileage"
									value={locationMileage}
									className={`form-control ${errors.locationMileage ? 'is-invalid' : ''}`}
									onChange={(e) => setLocationMileage(e.target.value)}
								>
								</input>
								
								{errors.locationMileage && <div className="invalid-feedback">{errors.locationMileage}</div>}
							</div>
							<div className="form-group mb-3">
								<label className="form-label">Location Type</label>
								<input
									type="text"
									placeholder="Location Type"
									name="locationType"
									value={locationType}
									className={`form-control ${errors.locationType ? 'is-invalid' : ''}`}
									onChange={(e) => setLocationType(e.target.value)}
								>
								</input>
								
								{errors.locationType && <div className="invalid-feedback">{errors.locationType}</div>}
							</div>
                            <div className="form-group mb-3">
								<label className="form-label">Location Name</label>
								<input
									type="text"
									placeholder="Location Name"
									name="locationName"
									value={locationName}
									className={`form-control ${errors.locationName ? 'is-invalid' : ''}`}
									onChange={(e) => setLocationName(e.target.value)}
								>
								</input>
								
								{errors.locationName && <div className="invalid-feedback">{errors.locationName}</div>}
							</div>
							<button className="btn btn-dark mb-2" onClick={saveOrUpdateLocation}>Submit</button>
							<button className="btn btn-dark mb-2" onClick={back} style={{ marginLeft: '10px' }}>Back</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	)
}
export default DCLocation