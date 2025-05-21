// import React, { useState, ChangeEvent, FormEvent } from 'react';
// import axios, { AxiosResponse } from 'axios';
// import { Alert, Button, Col, Form, FormGroup, Input, Label, Row } from 'reactstrap';
//
// // Type for form state
// interface ClientFormData {
//   firstName: string;
//   lastName: string;
//   email: string;
//   phoneNumber: string;
// }
//
// // (Optional) Type for API response if you know its shape
// interface ApiResponse {
//   success: boolean;
//   message?: string;
//   data?: any;
// }
//
// export const Home: React.FC = () => {
//   const [formData, setFormData] = useState<ClientFormData>({
//     firstName: '',
//     lastName: '',
//     email: '',
//     phoneNumber: '',
//   });
//
//   const [submitted, setSubmitted] = useState(false);
//   const [error, setError] = useState('');
//
//   const handleChange = (e: ChangeEvent<HTMLInputElement>) => {
//     const { name, value } = e.target;
//     setFormData(prev => ({
//       ...prev,
//       [name]: value,
//     }));
//   };
//
//   const handleSubmit = async (e: FormEvent) => {
//     e.preventDefault();
//
//     try {
//       const response: AxiosResponse<ApiResponse> = await axios.post(
//         'http://localhost:8080/api/customer/save',
//         {
//           firstname: formData.firstName,
//           lastname: formData.lastName,
//           email: formData.email,
//           phoneNumber: formData.phoneNumber,
//         },
//         {
//           withCredentials: true,
//         }
//       );
//
//
//       setSubmitted(true);
//       setError('');
//       // console.log('Saved:', response.data);
//     } catch (err: any) {
//       if (err?.response?.status === 401 || err?.code === 'ERR_NETWORK') {
//         window.location.href = 'http://localhost:8080/oauth2/authorization/oidc';
//       } else {
//         setError('Error saving client. Please check the console for more info.');
//         console.error(err);
//       }
//     }
//   };
//
//   return (
//     <Row>
//       <Col md="6" className="offset-md-3">
//         <h2 className="display-5">Register Client</h2>
//
//         <Form onSubmit={handleSubmit}>
//           <FormGroup>
//             <Label for="firstName">First Name</Label>
//             <Input type="text" name="firstName" id="firstName" value={formData.firstName} onChange={handleChange} required />
//           </FormGroup>
//           <FormGroup>
//             <Label for="lastName">Last Name</Label>
//             <Input type="text" name="lastName" id="lastName" value={formData.lastName} onChange={handleChange} required />
//           </FormGroup>
//           <FormGroup>
//             <Label for="email">Email</Label>
//             <Input type="email" name="email" id="email" value={formData.email} onChange={handleChange} required />
//           </FormGroup>
//           <FormGroup>
//             <Label for="phoneNumber">Phone Number</Label>
//             <Input type="number" name="phoneNumber" id="phoneNumber" value={formData.phoneNumber} onChange={handleChange} required />
//           </FormGroup>
//           <Button color="primary" type="submit">Save Client</Button>
//         </Form>
//
//         {submitted && (
//           <Alert color="success" className="mt-3">
//             Client saved successfully!
//           </Alert>
//         )}
//         {error && (
//           <Alert color="danger" className="mt-3">
//             {error}
//           </Alert>
//         )}
//       </Col>
//     </Row>
//   );
// };
//
// export default Home;

import React, { useState, ChangeEvent, FormEvent } from 'react';
import axios, { AxiosResponse } from 'axios';
import { Alert, Button, Col, Form, FormGroup, Input, Label, Row } from 'reactstrap';

// Type for form state
interface ClientFormData {
  firstName: string;
  lastName: string;
  email: string;
  phoneNumber: string;
}

// (Optional) Type for API response if you know its shape
interface ApiResponse {
  success: boolean;
  message?: string;
  data?: any;
}

export const Home: React.FC = () => {
  const [formData, setFormData] = useState<ClientFormData>({
    firstName: '',
    lastName: '',
    email: '',
    phoneNumber: '',
  });

  const [submitted, setSubmitted] = useState(false);
  const [error, setError] = useState('');

  const handleChange = (e: ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target;
    setFormData(prev => ({
      ...prev,
      [name]: value,
    }));
  };

  const handleSubmit = async (e: FormEvent) => {
    e.preventDefault();

    try {
      await axios.post(
        'http://localhost:8080/api/customer/save',
        {
          firstname: formData.firstName,
          lastname: formData.lastName,
          email: formData.email,
          phoneNumber: formData.phoneNumber,
        },
        {
          withCredentials: true,
        },
      );

      setSubmitted(true); // Show success message
      setError('');
      setFormData({
        // 🔁 Clear the form after success
        firstName: '',
        lastName: '',
        email: '',
        phoneNumber: '',
      });

      // Optionally hide success message after a few seconds
      setTimeout(() => setSubmitted(false), 3000);
    } catch (err: any) {
      // if (err?.response?.status === 401 || err?.code === 'ERR_NETWORK') {
      //   window.location.href = 'http://localhost:8080/oauth2/authorization/oidc';
      // } else {
      setError('Error saving client. Please check the console for more info.');
      console.error(err);
   // }
  }
};

return (
  <Row>
    <Col md="6" className="offset-md-3">
      <h2 className="display-5">Register Client</h2>

      <Form onSubmit={handleSubmit}>
        <FormGroup>
          <Label for="firstName">First Name</Label>
          <Input type="text" name="firstName" id="firstName" value={formData.firstName} onChange={handleChange} required />
        </FormGroup>
        <FormGroup>
          <Label for="lastName">Last Name</Label>
          <Input type="text" name="lastName" id="lastName" value={formData.lastName} onChange={handleChange} required />
        </FormGroup>
        <FormGroup>
          <Label for="email">Email</Label>
          <Input type="email" name="email" id="email" value={formData.email} onChange={handleChange} required />
        </FormGroup>
        <FormGroup>
          <Label for="phoneNumber">Phone Number</Label>
          <Input type="number" name="phoneNumber" id="phoneNumber" value={formData.phoneNumber} onChange={handleChange} required />
        </FormGroup>
        <Button color="primary" type="submit">
          Save Client
        </Button>
      </Form>

      {submitted && (
        <Alert color="success" className="mt-3">
          Client saved successfully!
        </Alert>
      )}
      {error && (
        <Alert color="danger" className="mt-3">
          {error}
        </Alert>
      )}
    </Col>
  </Row>
);
};

export default Home;
