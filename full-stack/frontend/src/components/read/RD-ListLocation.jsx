import React, {useEffect, useState} from 'react'
import {useNavigate, useParams} from "react-router-dom";
// more imports needed here

const RDListLocation = () => {

	const [locations, setLocations] = useState([]);
	const {id : regionId, chopcode : chopCode} = useParams();
	const [subdivisionName, setSubdivisionName] = useState('');

	const navigator = useNavigate();

    useEffect(() => {
		if (chopCode) {
			// Insert Fetch locations
            

			// Insert Fetch subdivision name


            // test data to be deleted after
			const dummyLocations = [
				{ mileage: '0.25', type: 'Signals - Controlled', name: 'Smiths Falls Centre' },
				{ mileage: '1.43', type: 'Grade Crossing Warning System', name: 'Carroll Road' },
				{ mileage: '2.00', type: 'Signals - Automatic', name: 'Glenview Road' },
			  ];
			const dummySubdivisionName = "Dummy Subdivision";

			setLocations(dummyLocations);
			setSubdivisionName(dummySubdivisionName);
		}
	}, [chopCode]);

    function back() {
		navigator(`/reader/regions/${regionId}/subdivisions`);
	}

	function plan(mileage) {
		console.log(mileage);
		navigator(`/reader/regions/${regionId}/subdivisions/${chopCode}/locations/${mileage}/plans`);
	}

    return (
        <div className='container'><br />
			<h2>{subdivisionName} Locations</h2>
			<button className="btn btn-dark mb-2" onClick={back}>Back</button>
			<table className='table table-striped table-bordered'>
				<thead>
					<tr>
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