import React, {useEffect, useState} from 'react'
import {useNavigate, useParams} from "react-router-dom";
import {createLocation, getLocation, updateLocation} from "../../services/RegionService.js";
// more imports needed here

const DCLocation = () => {
	const [locationChopCode, setLocationChopCode] = useState('');
	const [locationMileage, setLocationMileage] = useState('')
	const [locationType, setLocationType] = useState('')
    const [locationName, setLocationName] = useState('')
	const {id : regionId, chopcode : chopCode, mileage} = useParams();

	const [errors, setErrors] = useState({
		locationChopCode: '',
		locationMileage: '',
		locationType: '',
        locationName: ''
	})

	const navigator = useNavigate();

	useEffect(() => {
		if (mileage) {
			getLocation(regionId, chopCode, mileage).then((response) => {
				setLocationChopCode(response.data.chopCode);
				setLocationMileage(response.data.mileage);
				setLocationType(response.data.locationType);
				setLocationName(response.data.locationName);
			}).catch(error => {
				console.error("Error fetching location:", error.response?.data || error.message);
			});
		}
	}, [chopCode, mileage])

	function saveOrUpdateLocation(e) {
		e.preventDefault();

        console.log("Submit button clicked");

		if (validateForm()) {

			const location = {
				chopCode: locationChopCode,
				mileage: locationMileage,
				locationType: locationType,
				locationName: locationName
			}
			console.log("Location object: ", location)

			if (mileage) {
				// update location
				updateLocation(regionId, chopCode, mileage, location).then((response) => {
					console.log("Update successful: ", response.data);
					navigator(`/documentcontrol/regions/${regionId}/subdivisions/${chopCode}/locations`);
				}).catch(error => {
					console.error(error);
				})
			} else {
				// add location
				createLocation(regionId, chopCode, location).then((response) => {
					console.log("Create successful: ", response.data);
					navigator(`/documentcontrol/regions/${regionId}/subdivisions/${chopCode}/locations`);
				}).catch(errors => {
					console.error(errors);
				})
			}
		} else {
            console.log("Validation failed");
        }
	}

	function validateForm() {
		let valid = true;
		const errorsCopy = {... errors}

		if (locationChopCode.trim()) {
			errorsCopy.locationChopCode = '';
		} else {
			errorsCopy.locationChopCode = 'CHOP Code is required';
			valid = false;
		}

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
								<label className="form-label">CHOP Code</label>
								<input
									type="text"
									placeholder="CHOP Code"
									name="chopCode"
									value={locationChopCode}
									className={`form-control ${errors.locationChopCode ? 'is-invalid' : ''}`}
									onChange={(e) => setLocationChopCode(e.target.value)}
								>
								</input>

                                {errors.locationChopCode && <div className="invalid-feedback">{errors.locationChopCode}</div>}
                            </div>
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

								{errors.locationMileage &&
									<div className="invalid-feedback">{errors.locationMileage}</div>}
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