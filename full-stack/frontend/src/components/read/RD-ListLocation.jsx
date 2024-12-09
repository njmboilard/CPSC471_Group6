import React, {useEffect, useState} from 'react'
import {useNavigate, useParams} from "react-router-dom";
import {getSubdivision, listLocations, listSubdivisions} from "../../services/RegionService.js";

const RDListLocation = () => {

	const [locations, setLocations] = useState([]);
	const {id : regionId, chopcode : chopCode} = useParams();
	const [subdivisionName, setSubdivisionName] = useState('');

	const navigator = useNavigate();

    useEffect(() => {
		if (chopCode) {
			// Fetch locations
			listLocations(regionId, chopCode).then((response) => {
				setLocations(response.data);
			}).catch(error => {
				console.error("Error fetching locations:", error.response?.data || error.message);
			});

			// Fetch subdivision name
			getSubdivision(regionId, chopCode).then((response) => {
				setSubdivisionName(response.data.name);
			}).catch(error => {
				console.error("Error fetching subdivision name:", error.response?.data || error.message);
			});


            // test data to be deleted after
			// const dummyLocations = [
			// 	{ chopCode: "BELL", mileage: '0.25', type: 'Signals - Controlled', name: 'Smiths Falls Centre' },
			// 	{ chopCode: "BELL", mileage: '1.43', type: 'Grade Crossing Warning System', name: 'Carroll Road' },
			// 	{ chopCode: "BELL", mileage: '2.00', type: 'Signals - Automatic', name: 'Glenview Road' },
			//   ];
			// const dummySubdivisionName = "Dummy Subdivision";
			//
			// setLocations(dummyLocations);
			// setSubdivisionName(dummySubdivisionName);
		}
	}, [chopCode]);

    function back() {
		navigator(`/reader/regions/${regionId}/subdivisions`);
	}

	function plan(mileage) {
		console.log(mileage);
		navigator(`/reader/regions/${regionId}/subdivisions/${chopCode}/locations/${mileage}/plans`);
	}


    // NOTE: the keys might need to be modified since only one is listed here but there are multiple
    return (
        <div className='container'><br />
			<h2>{subdivisionName} Locations</h2>
			<button className="btn btn-dark mb-2" onClick={back}>Back</button>
			<table className='table table-striped table-bordered'>
				<thead>
					<tr>
                        <th>Chop Code</th>
						<th>Mileage</th>
						<th>Location Type</th>
						<th>Location Name</th>
                        <th>Actions</th>
					</tr>
				</thead>
				<tbody>
					{
						locations.map(location =>
							<tr key={location.mileage}>
                                <td>{location.chopCode}</td>
								<td>{location.mileage}</td>
								<td>{location.type}</td>
                                <td>{location.name}</td>
								<td>
									<button className="btn btn-dark" onClick={() => plan(location.mileage)}>Plans</button>
								</td>
							</tr>
						)
					}
				</tbody>
			</table>
		</div>
    )
};

export default RDListLocation;